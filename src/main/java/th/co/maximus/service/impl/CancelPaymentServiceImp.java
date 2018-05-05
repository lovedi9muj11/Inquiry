package th.co.maximus.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import th.co.maximus.bean.DeductionManualBean;
import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.bean.TrsChequeRefManualBean;
import th.co.maximus.bean.TrsMethodManualBean;
import th.co.maximus.bean.TrscreDitrefManualBean;
import th.co.maximus.core.utils.ReciptNoGenCode;
import th.co.maximus.dao.DeductionManualDao;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.dao.TrsChequeRefManualDao;
import th.co.maximus.dao.TrsMethodManualDao;
import th.co.maximus.dao.TrscreDitrefManualDao;
import th.co.maximus.service.CancelPaymentService;

@Service
public class CancelPaymentServiceImp implements CancelPaymentService {
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	@Autowired
	private PaymentInvoiceManualDao paymentInvoiceManualDao;
	
	@Autowired
	private DeductionManualDao deductionManualDao;
	
	@Autowired
	private PaymentManualDao paymentManualDao;
	
	@Autowired
	private TrsChequeRefManualDao trsChequeRefManualDao;
	
	@Autowired
	private TrscreDitrefManualDao trscreDitrefManualDao;
	
	@Autowired
	private ReciptNoGenCode reciptNoGenCode;
	
	@Autowired
	private TrsMethodManualDao trsMethodManualDao;

	@Override
	public List<PaymentMMapPaymentInvBean> findAllCancelPayment() {
		return paymentInvoiceManualDao.findPaymentMuMapPaymentInV();
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findAllCancelPaymentFromId(long manualId) {
		return paymentInvoiceManualDao.findPaymentMuMapPaymentInVFromId(manualId);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> serviceCriteriaFromInvoiceOrReceiptNo(String receiptNo, String invoiceNo) {
		return paymentInvoiceManualDao.findCriteriaFromInvoiceOrReceiptNo(receiptNo, invoiceNo);
	}

	@Override
	public boolean insertAndUpdateCancelPayment(PaymentMMapPaymentInvBean paymentMMapPaymentInvBean) {
		boolean resultReturn = true;
		PaymentInvoiceManualBean paymentInvoiceManualBean = new PaymentInvoiceManualBean();
		int manualID = 0;
		try {
			
			//update status
			paymentInvoiceManualDao.updateRecodeStatusFromReceiptNo("C", paymentMMapPaymentInvBean.getManualId());
			paymentInvoiceManualDao.updateStatusPaymentInvoice(paymentMMapPaymentInvBean.getManualId());
			if ("02".equals(paymentMMapPaymentInvBean.getStatusCancelPayment())) {
				//Insert PaymentManual
				List<PaymentManualBean> paymentManual = paymentManualDao.findPaymentManualFromNanualId(paymentMMapPaymentInvBean.getManualId());
				if(!paymentManual.isEmpty()) {
					PaymentManualBean paymentManualBean = new PaymentManualBean();
					for(PaymentManualBean resultPaymentManual : paymentManual) {
						paymentManualBean.setInvoiceNo(resultPaymentManual.getInvoiceNo());
						paymentManualBean.setReceiptNoManual(reciptNoGenCode.genCodeRecipt(resultPaymentManual.getDocType()));
						paymentManualBean.setPaidDate(resultPaymentManual.getPaidDate());
						paymentManualBean.setBrancharea(resultPaymentManual.getBrancharea());
						paymentManualBean.setBranchCode(resultPaymentManual.getBranchCode());
						paymentManualBean.setPaidAmount(resultPaymentManual.getPaidAmount());
						paymentManualBean.setSource(resultPaymentManual.getSource());
						paymentManualBean.setClearing(resultPaymentManual.getClearing());
						paymentManualBean.setRemark(resultPaymentManual.getRemark());
						paymentManualBean.setCreateBy(resultPaymentManual.getCreateBy());
						paymentManualBean.setCreateDate(resultPaymentManual.getCreateDate());
						paymentManualBean.setUpdateBy(resultPaymentManual.getUpdateBy());
						//paymentManualBean.setUpdateDate(resultPaymentManual.getUpdateDate());
						paymentManualBean.setRecordStatus("A");
						paymentManualBean.setAccountNo(resultPaymentManual.getAccountNo());
						paymentManualBean.setPaytype(resultPaymentManual.getPaytype());
						paymentManualBean.setDocType(resultPaymentManual.getDocType());
						paymentManualBean.setChange(resultPaymentManual.getChange());
						paymentManualBean.setAmount(resultPaymentManual.getAmount());
						paymentManualBean.setVatRate(resultPaymentManual.getVatRate());
						paymentManualBean.setVatAmount(resultPaymentManual.getVatAmount());
						manualID =  paymentManualDao.insertPayment(paymentManualBean);
					}
				}
				//Insert PaymentInvoice
				List<PaymentInvoiceManualBean> resultPaymentInvoice = paymentInvoiceManualDao.findPaymentInvoiceFromManualId(paymentMMapPaymentInvBean.getManualId());
				if(!resultPaymentInvoice.isEmpty()) {
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
					paymentInvoiceManualBean.setRemark(resultPaymentInvoice.get(0).getRemark());
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
				}		
			}
		}catch (Exception e) {
			resultReturn = false;
			e.printStackTrace();
			
		}
		return resultReturn;
	}

}
