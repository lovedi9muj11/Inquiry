package th.co.maximus.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.TmpInvoiceBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.dao.CancelPaymentDTO;
import th.co.maximus.dao.CancelPaymentDTO.Receipt;
import th.co.maximus.dao.DeductionManualDao;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.dao.TrsChequeRefManualDao;
import th.co.maximus.dao.TrsMethodManualDao;
import th.co.maximus.dao.TrscreDitrefManualDao;
import th.co.maximus.model.DuductionEpisOffline;
import th.co.maximus.model.OfflineResultModel;
import th.co.maximus.model.PaymentDTO;
import th.co.maximus.model.PaymentEpisOfflineDTO;
import th.co.maximus.model.PaymentInvoiceEpisOffline;
import th.co.maximus.model.ReceiptOfflineModel;
import th.co.maximus.model.TrsChequerefEpisOffline;
import th.co.maximus.model.TrsCreditrefEpisOffline;
import th.co.maximus.model.TrsMethodEpisOffline;
import th.co.maximus.service.CancelPaymentService;
import th.co.maximus.service.ClearingPaymentEpisOfflineService;
import th.co.maximus.service.TmpInvoiceService;

@Service
public class ClearingPaymentEpisOfflineServiceImpl implements ClearingPaymentEpisOfflineService{
	
	@Value("${url.online}")
	private String url;

	RestTemplate restTemplate;
	
	public ClearingPaymentEpisOfflineServiceImpl() {
		restTemplate = new RestTemplate();
	}

	@Autowired
	private PaymentManualDao paymentManualDao;
	
	@Autowired
	private PaymentInvoiceManualDao paymentInvoiceManualDao;
	
	@Autowired
	private DeductionManualDao deductionManualDao;
	
	@Autowired
	private TrsMethodManualDao trsMethodManualDao;
	
	@Autowired
	private TrsChequeRefManualDao trsChequeRefManualDao;
	
	@Autowired
	private TrscreDitrefManualDao TrscreDitrefManualDao;
	
	@Autowired
	private TmpInvoiceService tmpInvoiceService;
	
	@Autowired
	private CancelPaymentService cancelPaymentService;
	

	@Override
	public ReceiptOfflineModel findRecipt(Integer manualId) throws SQLException {
		// TODO Auto-generated method stub
		return paymentManualDao.findByManualId(manualId);
	}
	
	@Override
	public ReceiptOfflineModel findReciptStatus(Integer manualId,String status) throws SQLException {
		// TODO Auto-generated method stub
		return paymentManualDao.findByManualId(manualId,status);
	}

	@Override
	public List<PaymentInvoiceEpisOffline> findPaymentInvoice(Integer manualId)throws SQLException {
		// TODO Auto-generated method stub
		return paymentInvoiceManualDao.findByManualId(manualId);
	}

	@Override
	public List<DuductionEpisOffline> findDeduction(Integer manualId) throws Exception {
		// TODO Auto-generated method stub
		return deductionManualDao.findDeductionManual(manualId);
	}

	@Override
	public List<TrsMethodEpisOffline> findTrsMethod(Integer manualId) throws Exception {
		// TODO Auto-generated method stub
		return trsMethodManualDao.findByManualId(manualId);
	}

	@Override
	public List<TrsCreditrefEpisOffline> findTrsCredit(long methodTrsId) throws Exception{
		// TODO Auto-generated method stub
		return TrscreDitrefManualDao.findByMethodId(methodTrsId);
	}

	@Override
	public List<TrsChequerefEpisOffline> findTrsCheq(long methodTrsId) throws SQLException {
		// TODO Auto-generated method stub
		return trsChequeRefManualDao.findByManualId(methodTrsId);
	}

	@Override
	public void updateStatusClearing(long manualId,String status) throws Exception {
		// TODO Auto-generated method stub
		 paymentManualDao.udpateStatus(manualId,status);
	}

	@Override
	public List<OfflineResultModel> callOnlinePayment(List<PaymentMMapPaymentInvBean> creteria) {
		List<OfflineResultModel> objMessage = new ArrayList<OfflineResultModel>();
	
		List<PaymentEpisOfflineDTO> PaymentEpisOfflineDTOList = new ArrayList<>();
		List<PaymentInvoiceEpisOffline> paymentList = new ArrayList<>();
		List<DuductionEpisOffline> deductionList = new ArrayList<>();
		List<TrsMethodEpisOffline> methodList = new ArrayList<>();
		List<TrsCreditrefEpisOffline> creditList = new ArrayList<>();
		List<TrsChequerefEpisOffline> chequeList = new ArrayList<>();
		TmpInvoiceBean invoid = new TmpInvoiceBean();
		try {
			Boolean isOther = false;
			if (creteria != null) {
				for (PaymentMMapPaymentInvBean payment : creteria) {
					PaymentEpisOfflineDTO paymentEpisOfflineDTO = new PaymentEpisOfflineDTO();
					Integer manualId =  Integer.valueOf(payment.getManualId().toString());
					ReceiptOfflineModel recrip = findReciptStatus(manualId,payment.getRecordStatus());
					paymentEpisOfflineDTO.setManualID(manualId.toString());
					if (recrip != null) {
						paymentList = findPaymentInvoice(manualId);
						for (PaymentInvoiceEpisOffline pay : paymentList) {
							if ("OTHER".equals(pay.getServiceType())) {
								isOther = true;
							}
						}
						deductionList = findDeduction(manualId);
						methodList = findTrsMethod(manualId);
						if (!isOther) {
							invoid = tmpInvoiceService.findByManualId(manualId);
						}
						if (methodList.size() > 0 && methodList != null) {
							for (TrsMethodEpisOffline method : methodList) {
								if (method.getCode().equals("CH")) {
									chequeList = findTrsCheq(method.getId());
									method.setTrsChequerefEpisOffline(chequeList);
								} else if (method.getCode().equals("CR")) {
									creditList = findTrsCredit(method.getId());
									method.setTrsCreditrefEpisOffline(creditList);
								}

							}
							paymentEpisOfflineDTO.setTrsMethod(methodList);
						}
						paymentEpisOfflineDTO.setAccountNo(recrip.getAccountNo());
						paymentEpisOfflineDTO.setReceiptNo(recrip.getReceiptNo());
						paymentEpisOfflineDTO.setBranchArea(recrip.getBranchArea());
						paymentEpisOfflineDTO.setBranchCode(recrip.getBranchCode());
						paymentEpisOfflineDTO.setInvoiceNo(recrip.getInvoiceNo());
						paymentEpisOfflineDTO.setPaidDate(recrip.getPaidDate());
						paymentEpisOfflineDTO.setVatAmount(recrip.getVatAmount());
						paymentEpisOfflineDTO.setVatRate(new BigDecimal(paymentList.get(0).getVatRate()));
						if (isOther) {
						
							paymentEpisOfflineDTO.setPaidAmount(recrip.getPaidAmount());
						} else {
							paymentEpisOfflineDTO
									.setPaidAmount(recrip.getAmount().add(new BigDecimal(invoid.getDiscount())));
						}
						paymentEpisOfflineDTO.setSource(recrip.getSource());
						paymentEpisOfflineDTO.setRemark(recrip.getRemark());
						paymentEpisOfflineDTO.setManualID(manualId +"");
						List<PaymentInvoiceEpisOffline> paymentList2 = new ArrayList<>();
						if (!isOther) {
							for (PaymentInvoiceEpisOffline data : paymentList) {
								
							
								if ("Y".equals(invoid.getIsDiscountFlg())) {
									BigDecimal disVat = (new BigDecimal(invoid.getDiscount())
											.multiply(new BigDecimal(data.getVatRate()))).divide(new BigDecimal(data.getVatRate()));
									data.setDiscount(new BigDecimal(invoid.getDiscount()).subtract(disVat));
									data.setDiscountVat(disVat);
								
								} else {
									if (null != invoid.getDiscount()) {
										data.setDiscount(new BigDecimal(invoid.getDiscount()));
									} else {

										data.setDiscountVat(BigDecimal.ZERO);
									}
								}

								paymentList2.add(data);
							}
							paymentEpisOfflineDTO.setPaymentInvoice(paymentList2);
						}else{
							paymentEpisOfflineDTO.setPaymentInvoice(paymentList);
						}
						if (deductionList.size() > 0) {
							paymentEpisOfflineDTO.setDuduction(deductionList);
						}
					}
					PaymentEpisOfflineDTOList.add(paymentEpisOfflineDTO);
				}

			}
			String postUrl = "";
			if(isOther){
				 postUrl = "http://localhost:8080/EpisWeb/offline/paymentManualSaveOffline"; // /offline/insertPayment
			}else{
				 postUrl = "http://localhost:8080/EpisWeb/offline/paymentManualSaveOffline"; // /offline/insertPayment
			}
			
			ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, PaymentEpisOfflineDTOList, String.class);
			
			if(null != postResponse.getBody()) {
				JSONArray jsonArray = new JSONArray(postResponse.getBody());
				for(int i=0; i<jsonArray.length(); i++) {
					OfflineResultModel obj = new OfflineResultModel();
					obj.setManualId(jsonArray.getJSONObject(i).getLong("manualId"));
					obj.setMessage(jsonArray.getJSONObject(i).getString("message"));
					obj.setStatus(jsonArray.getJSONObject(i).getString("status"));
					obj.setRecriptNo(jsonArray.getJSONObject(i).getString("recriptNo"));
					if(("SUCCESS").equals(obj.getStatus())) {
						obj.setManualIdOnline(jsonArray.getJSONObject(i).getLong("manualIdOnline"));
					}
					objMessage.add(obj);
				}
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return objMessage;
	}
	
	@Override
	public HashMap<String, Object> clearingCencelPayment() throws Exception {
		HashMap<String, Object> result = new HashMap<>();
		List<PaymentMMapPaymentInvBean> list = new ArrayList<>();
		List<PaymentDTO> dtoList = new ArrayList<>();
		list = cancelPaymentService.findAllCancelPayments(Constants.CLEARING.STATUS_N);
		CancelPaymentDTO cancelDTO = new CancelPaymentDTO();
		String postUrl = "";
		List<OfflineResultModel> objMessage = callOnlinePayment(list);
		try {

			for (OfflineResultModel offlineResultModel : objMessage) {
				if (offlineResultModel.getStatus().equals("SUCCESS")) {

					for (PaymentMMapPaymentInvBean payment : list) {
						if (offlineResultModel.getManualId() == payment.getManualId()) {
							PaymentDTO manualDTO = new PaymentDTO();

							manualDTO.setAccountNo(payment.getAccountNo());
							manualDTO.setBranchCode(payment.getBranchCode());
							manualDTO.setBranchArea(payment.getBrancharea());
							manualDTO.setInvoiceNo(payment.getInvoiceNo());
							manualDTO.setReceiptNoManual(payment.getReceiptNoManual());
							manualDTO.setRemark(payment.getRemark());
							manualDTO.setManualId(offlineResultModel.getManualIdOnline());
							manualDTO.setCreateBy(payment.getCreateBy());
							manualDTO.setPaidAmount(payment.getPaidAmount());
							manualDTO.setRecordStatus("");
							manualDTO.setSource(payment.getSource());
							manualDTO.setVatAmount(payment.getVatAmount());
							manualDTO.setUserLogin(payment.getCreateBy());
							manualDTO.setUserName(payment.getCreateBy());
							dtoList.add(manualDTO);

							cancelDTO = dtoCancel(payment);
						}
					}
					if (dtoList.size() > 0) {
						postUrl = url.concat("/offlineCancel/paymentManualCancelOnline.json?ap=SSO&un=backofficer01&pw=password");
						restTemplate.postForEntity(postUrl, dtoList, String.class);
						
						postUrl = url.concat("/offlineCancel/cancelPaymentProductOffline.json?ap=SSO&un=backofficer01&pw=password");
						restTemplate.postForEntity(postUrl, cancelDTO, String.class);
						updateStatusClearing(offlineResultModel.getManualId(), Constants.CLEARING.STATUS_Y);

					}

				} else {
					updateStatusClearing(offlineResultModel.getManualId(), Constants.CLEARING.STATUS_ERROR);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("data", objMessage);
		return result;
	}
	
	public CancelPaymentDTO dtoCancel(PaymentMMapPaymentInvBean payment) {
		CancelPaymentDTO dto = new CancelPaymentDTO();
		Receipt rp = new Receipt();
		List<Receipt> rpList = new ArrayList<>();
		rp.setAccountName(payment.getCustomerName());
		rp.setAddrLine1(payment.getAddressNewCancelPayment());
		rp.setNo(payment.getReceiptNoManual());
		rp.setReasonCode(payment.getReasonCode());
		rp.setIsIbaiss(payment.getServiceType());
		rpList.add(rp);
		dto.setReceipts(rpList);
		dto.setFlagCancel("Y");
		dto.setFlgNewReceipt(false);
		dto.setUserAuthen(payment.getCreateBy());

		return dto;
	}


}
