package th.co.maximus.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.bean.InvoiceBean;
import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.bean.TrsMethodManualBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.core.utils.ReciptNoGenCode;
import th.co.maximus.core.utils.Utils;
import th.co.maximus.dao.MasterDatasDao;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.dao.TrsMethodManualDao;
import th.co.maximus.model.TrsMethodEpisOffline;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.service.CancelPaymentService;

@Service
public class CancelPaymentServiceImp implements CancelPaymentService {
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Autowired
	private PaymentInvoiceManualDao paymentInvoiceManualDao;

	@Autowired
	private PaymentManualDao paymentManualDao;

	@Autowired
	private ReciptNoGenCode reciptNoGenCode;

	@Autowired
	private TrsMethodManualDao trsMethodManualDao;
	
	@Autowired
	private MasterDatasDao masterDatasDao;

	@Override
	public List<PaymentMMapPaymentInvBean> findAllCancelPayment() throws Exception {
		List<PaymentMMapPaymentInvBean> result = paymentInvoiceManualDao.findPaymentMuMapPaymentInV();
		for (PaymentMMapPaymentInvBean resultBean : result) {
			List<TrsMethodEpisOffline> methodResult = trsMethodManualDao
					.findByManualId(Long.valueOf(resultBean.getManualId()));
			StringBuffer paymentMethod = new StringBuffer();
			for (TrsMethodEpisOffline method : methodResult) {

				if (paymentMethod.toString().equals("")) {
					paymentMethod.append(method.getName());
				} else {
					paymentMethod.append("+" + method.getName());
				}

			}
			resultBean.setPaidDateStr(dt.format(resultBean.getCreateDate()));
			if ("IBACSS".equals(resultBean.getServiceType())) {
				resultBean.setPeriod(Utils.periodFormat(resultBean.getPeriod()));
			} else if ("OTHER".equals(resultBean.getServiceType())) {
				resultBean.setPeriod("-");
			}

			resultBean.setCreateDateStr(dt.format(resultBean.getCreateDate()));
			resultBean.setPaymentMethod(paymentMethod.toString());
		}

//		Collections.sort(result, new Comparator<PaymentMMapPaymentInvBean>() {
//			@Override
//			public int compare(PaymentMMapPaymentInvBean o1, PaymentMMapPaymentInvBean o2) {
//				return o2.getCreateDate().compareTo(o1.getCreateDate());
//			}
//		});
		return result;
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findAllCancelPaymentFromId(Long manualId) throws Exception {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
		for (PaymentMMapPaymentInvBean bean : paymentInvoiceManualDao.findPaymentMuMapPaymentInVFromId(manualId)) {
			if ("N".equals(bean.getClearing()) && "A".equals(bean.getRecordStatus())) {
				List<TrsMethodEpisOffline> methodResult = trsMethodManualDao
						.findByManualId(Long.valueOf(bean.getManualId()));
				StringBuffer paymentMethod = new StringBuffer();
				for (TrsMethodEpisOffline method : methodResult) {

					if (paymentMethod.toString().equals("")) {
						paymentMethod.append(method.getName());
					} else {
						paymentMethod.append("+" + method.getName());
					}

				}
				bean.setCreateDateStr(dt.format(bean.getCreateDate()));
				bean.setPaymentMethod(paymentMethod.toString());
				result.add(bean);
			}
		}
		return result;
	}

	@Override
	public List<PaymentMMapPaymentInvBean> serviceCriteriaFromInvoiceOrReceiptNo(String receiptNo, String invoiceNo)
			throws Exception {

		List<PaymentMMapPaymentInvBean> result = new ArrayList<PaymentMMapPaymentInvBean>();
		for (PaymentMMapPaymentInvBean resultBean : paymentInvoiceManualDao.findCriteriaFromInvoiceOrReceiptNo(receiptNo, invoiceNo)) {
			List<TrsMethodEpisOffline> methodResult = trsMethodManualDao.findByManualId(Long.valueOf(resultBean.getManualId()));
			StringBuffer paymentMethod = new StringBuffer();
			for (TrsMethodEpisOffline method : methodResult) {
				if (paymentMethod.toString().equals("")) {
					paymentMethod.append(method.getName());
				} else {
					paymentMethod.append("+" + method.getName());
				}

			}
			resultBean.setCreateDateStr(dt.format(resultBean.getCreateDate()));
			resultBean.setPaymentMethod(paymentMethod.toString());
			resultBean.setBrancharea(masterDatasDao.findByKey(resultBean.getBrancharea()).getValue());
			result.add(resultBean);
		}

//		Collections.sort(result, new Comparator<PaymentMMapPaymentInvBean>() {
//			@Override
//			public int compare(PaymentMMapPaymentInvBean o1, PaymentMMapPaymentInvBean o2) {
//				return o2.getCreateDate().compareTo(o1.getCreateDate());
//			}
//		});
		return result;
	}

	@Override
	@Transactional
	public PaymentResultReq insertAndUpdateCancelPayment(PaymentMMapPaymentInvBean paymentMMapPaymentInvBean) {
//		boolean resultReturn = true;
		PaymentResultReq paymentResultReq = new PaymentResultReq();
		PaymentInvoiceManualBean paymentInvoiceManualBean = new PaymentInvoiceManualBean();
		InvoiceBean invoiceBean = new InvoiceBean(); 
		
		UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String receiptId = "";
		int manualID = 0;
		try {

			// update status
			paymentInvoiceManualDao.updateRecodeStatusFromReceiptNo("C", paymentMMapPaymentInvBean.getManualId(), paymentMMapPaymentInvBean.getStatusCancelPayment().equals(Constants.CANCEL.CANCEL_SERVICE_01)?Constants.CANCEL.CANCEL_SERVICE:Constants.CANCEL.CANCEL_ADDR, profile.getUsername());
			paymentInvoiceManualDao.updateStatusPaymentInvoice(paymentMMapPaymentInvBean.getManualId());
			if ("02".equals(paymentMMapPaymentInvBean.getStatusCancelPayment())) {
				// Insert PaymentManual
				List<PaymentManualBean> paymentManual = paymentManualDao.findPaymentManualFromNanualId(paymentMMapPaymentInvBean.getManualId());
				if (!paymentManual.isEmpty()) {
					PaymentManualBean paymentManualBean = new PaymentManualBean();
					for (PaymentManualBean resultPaymentManual : paymentManual) {
						paymentManualBean = new PaymentManualBean();
						receiptId = resultPaymentManual.getReceiptNoManual();
						paymentManualBean.setInvoiceNo(resultPaymentManual.getInvoiceNo());
						paymentManualBean.setReceiptNoManual(reciptNoGenCode.genCodeRecipt(resultPaymentManual.getDocType()));
//						result = paymentManualBean.getReceiptNoManual();
						paymentResultReq.setDocumentNo(paymentManualBean.getReceiptNoManual());
						paymentManualBean.setPaidDate(resultPaymentManual.getPaidDate());
						paymentManualBean.setBrancharea(resultPaymentManual.getBrancharea());
						paymentManualBean.setBranchCode(resultPaymentManual.getBranchCode());
						paymentManualBean.setPaidAmount(resultPaymentManual.getPaidAmount());
						paymentManualBean.setSource(resultPaymentManual.getSource());
						paymentManualBean.setClearing(resultPaymentManual.getClearing());
						paymentManualBean.setRemark(resultPaymentManual.getRemark());
						paymentManualBean.setCreateBy(resultPaymentManual.getCreateBy());
						// paymentManualBean.setCreateDate(resultPaymentManual.getCreateDate());
						paymentManualBean.setUpdateBy(resultPaymentManual.getUpdateBy());
						// paymentManualBean.setUpdateDate(resultPaymentManual.getUpdateDate());
						paymentManualBean.setRecordStatus("A");
						paymentManualBean.setAccountNo(resultPaymentManual.getAccountNo());
						paymentManualBean.setPaytype(resultPaymentManual.getPaytype());
						paymentManualBean.setDocType(resultPaymentManual.getDocType());
						paymentManualBean.setChange(resultPaymentManual.getChange());
						paymentManualBean.setAmount(resultPaymentManual.getAmount());
//						paymentManualBean.setVatRate(resultPaymentManual.getVatRate());
						paymentManualBean.setVatAmount(resultPaymentManual.getVatAmount());
						manualID = paymentManualDao.insertPayment(paymentManualBean);
					}
				}
				// Insert payment_invoice_manual
				List<PaymentInvoiceManualBean> resultPaymentInvoice = paymentInvoiceManualDao.findPaymentInvoiceFromManualId(paymentMMapPaymentInvBean.getManualId());
				if (!resultPaymentInvoice.isEmpty()) {
					paymentInvoiceManualBean.setManualId(Long.valueOf(manualID));
					paymentInvoiceManualBean.setSource(resultPaymentInvoice.get(0).getSource());
					paymentInvoiceManualBean.setInvoiceNo(resultPaymentInvoice.get(0).getInvoiceNo());
					paymentInvoiceManualBean.setBeforVat(resultPaymentInvoice.get(0).getBeforVat());
					paymentInvoiceManualBean.setVatAmount(resultPaymentInvoice.get(0).getVatAmount());
					paymentInvoiceManualBean.setAmount(resultPaymentInvoice.get(0).getAmount());
					paymentInvoiceManualBean.setVatRate(resultPaymentInvoice.get(0).getVatRate());
					paymentInvoiceManualBean.setCustomerName(paymentMMapPaymentInvBean.getCustomerName());
					paymentInvoiceManualBean.setCustomerAddress(paymentMMapPaymentInvBean.getAddressNewCancelPayment());
					paymentInvoiceManualBean.setCustomerSegment(resultPaymentInvoice.get(0).getCustomerSegment());
					paymentInvoiceManualBean.setCustomerBranch(resultPaymentInvoice.get(0).getCustomerBranch());
					paymentInvoiceManualBean.setTaxNo(resultPaymentInvoice.get(0).getTaxNo());
					paymentInvoiceManualBean.setAccountSubNo(resultPaymentInvoice.get(0).getAccountSubNo());
					paymentInvoiceManualBean.setPeriod(resultPaymentInvoice.get(0).getPeriod());
					paymentInvoiceManualBean.setServiceType(resultPaymentInvoice.get(0).getServiceType());
					paymentInvoiceManualBean.setClearing(resultPaymentInvoice.get(0).getClearing());
					paymentInvoiceManualBean.setPrintReceipt(resultPaymentInvoice.get(0).getPrintReceipt());
					paymentInvoiceManualBean.setRemark("ยกเลิกใบเก่าออกใบใหม่ อ้างอิงเลขที่ :" + receiptId);
					paymentInvoiceManualBean.setCreateBy(resultPaymentInvoice.get(0).getCreateBy());
					paymentInvoiceManualBean.setUpdateBy(resultPaymentInvoice.get(0).getUpdateBy());
					paymentInvoiceManualBean.setRecordStatus("A");
					paymentInvoiceManualBean.setQuantity(resultPaymentInvoice.get(0).getQuantity());
					paymentInvoiceManualBean.setIncometype(resultPaymentInvoice.get(0).getIncometype());
					paymentInvoiceManualBean.setDiscountbeforvat(resultPaymentInvoice.get(0).getDiscountbeforvat());
					paymentInvoiceManualBean.setDiscountspecial(resultPaymentInvoice.get(0).getDiscountspecial());
					paymentInvoiceManualBean.setAmounttype(resultPaymentInvoice.get(0).getAmounttype());
					paymentInvoiceManualBean.setDepartment(resultPaymentInvoice.get(0).getDepartment());
					paymentInvoiceManualBean.setServiceName(resultPaymentInvoice.get(0).getServiceName());
					paymentInvoiceManualBean.setServiceCode(resultPaymentInvoice.get(0).getServiceCode());
					paymentInvoiceManualDao.insert(paymentInvoiceManualBean);
					
					if(true) {
						invoiceBean = paymentInvoiceManualDao.findInvoiceByManualId(paymentMMapPaymentInvBean.getManualId());
						paymentResultReq.setChkPaymentType(Constants.Service.SERVICE_TYPE_OTHER);
						if(null != invoiceBean.getManualId()) {
							paymentInvoiceManualDao.insertInvoice(invoiceBean);
							paymentResultReq.setChkPaymentType(Constants.Service.SERVICE_TYPE_IBACSS);
						}
					}
				}
				for (TrsMethodEpisOffline method : trsMethodManualDao.findByManualId(paymentMMapPaymentInvBean.getManualId())) {
					TrsMethodManualBean bean = new TrsMethodManualBean();
					bean.setCode(method.getCode());
					bean.setChequeNo(method.getChequeNo());
					bean.setAccountNo(method.getAccountNo());
					bean.setCreditId(method.getCreditNo());
					bean.setName(method.getName());
					bean.setAmount(method.getAmount().doubleValue());

					bean.setUpdateDttm(new Timestamp(new Date().getTime()));
					bean.setVersionStamp(1L);
					bean.setRemark(null);
					bean.setCreateBy(method.getCreateBy());
					bean.setCreateDate(new Timestamp(new Date().getTime()));
					bean.setUpdateBy(method.getCreateBy());
					bean.setUpdateDate(new Timestamp(new Date().getTime()));
					bean.setRecordStatus("A");
					bean.setManualId(Long.valueOf(manualID));
					trsMethodManualDao.insertTrsMethod(bean);
				}
				// insert payment_Invoice
				InvoiceBean resultInvoiceBean = paymentInvoiceManualDao.findInvoiceByManualId(paymentMMapPaymentInvBean.getManualId());
				resultInvoiceBean.setManualId(Long.valueOf(manualID));
				paymentInvoiceManualDao.insertInvoice(resultInvoiceBean);

			}
		} catch (Exception e) {
//			resultReturn = false;
			e.printStackTrace();

		}
		return paymentResultReq;
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findAllCancelPayments(String clearing) throws Exception {
		List<PaymentMMapPaymentInvBean> result = paymentInvoiceManualDao.findPaymentMuMapPaymentInVs(clearing);
		for (PaymentMMapPaymentInvBean resultBean : result) {
			List<TrsMethodEpisOffline> methodResult = trsMethodManualDao
					.findByManualId(Long.valueOf(resultBean.getManualId()));
			StringBuffer paymentMethod = new StringBuffer();
			for (TrsMethodEpisOffline method : methodResult) {
				if (paymentMethod.toString().equals("")) {
					paymentMethod.append(method.getName());
				} else {
					paymentMethod.append("+" + method.getName());
				}

			}
			resultBean.setPaidDateStr(dt.format(resultBean.getCreateDate()));
			if (null != resultBean.getPeriod()) {
				resultBean.setPeriod(Utils.periodFormat((resultBean.getPeriod())));
			}
			resultBean.setCreateDateStr(dt.format(resultBean.getCreateDate()));
			resultBean.setPaymentMethod(paymentMethod.toString());
		}

//		Collections.sort(result, new Comparator<PaymentMMapPaymentInvBean>() {
//			@Override
//			public int compare(PaymentMMapPaymentInvBean o1, PaymentMMapPaymentInvBean o2) {
//				return o2.getCreateDate().compareTo(o1.getCreateDate());
//			}
//		});
		return result;
	}

}
