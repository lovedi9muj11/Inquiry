package th.co.maximus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.model.DuductionEpisOffline;
import th.co.maximus.model.PaymentEpisOfflineDTO;
import th.co.maximus.model.PaymentInvoiceEpisOffline;
import th.co.maximus.model.ReceiptOfflineModel;
import th.co.maximus.model.TrsChequerefEpisOffline;
import th.co.maximus.model.TrsCreditrefEpisOffline;
import th.co.maximus.model.TrsMethodEpisOffline;
import th.co.maximus.service.CancelPaymentService;
import th.co.maximus.service.ClearingPaymentEpisOfflineService;

@Controller
public class ClearingPaymentEpisOffline {
	@Value("${url.online}")
	private String url;

	RestTemplate restTemplate;

	public ClearingPaymentEpisOffline() {
		restTemplate = new RestTemplate();
	}

	@Autowired
	private CancelPaymentService cancelPaymentService;

	@Autowired
	private ClearingPaymentEpisOfflineService clearingPaymentEpisOfflineService;

	public String callOnlinePayment(List<PaymentMMapPaymentInvBean> creteria) {
		String result = "";
		try {
			PaymentEpisOfflineDTO paymentEpisOfflineDTO = new PaymentEpisOfflineDTO();
			List<PaymentEpisOfflineDTO> PaymentEpisOfflineDTOList = new ArrayList<>();
			List<PaymentInvoiceEpisOffline> paymentList = new ArrayList<>();
			List<DuductionEpisOffline> deductionList = new ArrayList<>();
			List<TrsMethodEpisOffline> methodList = new ArrayList<>();
			List<TrsCreditrefEpisOffline> creditList = new ArrayList<>();
			List<TrsChequerefEpisOffline> chequeList = new ArrayList<>();
			if (creteria != null) {
				for (PaymentMMapPaymentInvBean payment : creteria) {
					Integer manualId = (int) (long) payment.getManualId();
					ReceiptOfflineModel recrip = clearingPaymentEpisOfflineService.findRecipt(manualId);
					if (recrip != null) {
						paymentList = clearingPaymentEpisOfflineService.findPaymentInvoice(manualId);
						deductionList = clearingPaymentEpisOfflineService.findDeduction(manualId);
						methodList = clearingPaymentEpisOfflineService.findTrsMethod(manualId);
						if (methodList.size() > 0 && methodList != null) {
							for (TrsMethodEpisOffline method : methodList) {
								if (method.getCode().equals("CH")) {
									chequeList = clearingPaymentEpisOfflineService.findTrsCheq(method.getId());
									method.setTrsChequerefEpisOffline(chequeList);
								} else if (method.getCode().equals("CR")) {
									creditList = clearingPaymentEpisOfflineService.findTrsCredit(method.getId());
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
						paymentEpisOfflineDTO.setPaidAmount(recrip.getPaidAmount());
						paymentEpisOfflineDTO.setSource(recrip.getSource());
						paymentEpisOfflineDTO.setRemark(recrip.getRemark());
						paymentEpisOfflineDTO.setManualID(recrip.getManualID());
						paymentEpisOfflineDTO.setPaymentInvoice(paymentList);
						if (deductionList.size() > 0) {
							paymentEpisOfflineDTO.setDuduction(deductionList);
						}

					}
					PaymentEpisOfflineDTOList.add(paymentEpisOfflineDTO);
				}
				// add object to arrayList

			}
			String postUrl = url.concat("/EpisWeb/offline/paymentManualSaveOffline"); // /offline/insertPayment
			ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, PaymentEpisOfflineDTOList,
					String.class);
			if(postResponse.getBody()!=null){
				result = postResponse.getBody();
			}else{
				result = "N";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "N";
		}
		return result;
	}

	@RequestMapping(value = { "/clearing/find" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<PaymentMMapPaymentInvBean> find(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
		result = cancelPaymentService.findAllCancelPayments(creteria.getClearing());
		return result;
	}

	@RequestMapping(value = { "/clearing/save" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void save(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
		result = cancelPaymentService.findAllCancelPayments(creteria.getClearing());
		if (result != null) {
			callOnlinePayment(result);

			for (PaymentMMapPaymentInvBean payment : result) {
				clearingPaymentEpisOfflineService.updateStatusClearing(payment.getManualId());
			}
		}

	}
}
