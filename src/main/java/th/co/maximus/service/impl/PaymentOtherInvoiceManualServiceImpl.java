package th.co.maximus.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.DeductionManualBean;
import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.TrsMethodManualBean;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.payment.bean.PaymentBillBean;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;
import th.co.maximus.payment.bean.PaymentTaxBean;
import th.co.maximus.service.PaymentOtherInvoiceManualService;

@Service
public class PaymentOtherInvoiceManualServiceImpl implements PaymentOtherInvoiceManualService {

	
	@Autowired PaymentInvoiceManualDao paymentInvoiceManualDao;

	@Override
	public void insertPaymentInvoiceManual(PaymentOtherFirstBean paymentBean,int userId) {
		String period = "";
		int payBill = 0;
		
		Date date = new Date();
		if(!paymentBean.getInputCustomerBillNo().equals("")){
		PaymentInvoiceManualBean paymentInvoiceManualBean = new PaymentInvoiceManualBean();
		
		
		paymentInvoiceManualBean.setManualId(Long.valueOf(userId));
		paymentInvoiceManualBean.setSource("OFFLINE");
		paymentInvoiceManualBean.setSubNo("");
		paymentInvoiceManualBean.setPeriod(period);
		paymentInvoiceManualBean.setServiceType("");
		paymentInvoiceManualBean.setClearing("N");
		paymentInvoiceManualBean.setPrintReceipt("");
		paymentInvoiceManualBean.setCreateBy("ADMIN");
		paymentInvoiceManualBean.setCreateDate(new Timestamp(date.getTime()));
		paymentInvoiceManualBean.setUpdateBy("ADMIN");
		paymentInvoiceManualBean.setUpdateDate(new Timestamp(date.getTime()));
		paymentInvoiceManualBean.setRecordStatus("A");
		paymentInvoiceManualBean.setTaxNo(paymentBean.getInputCustomerTaxNo());
		paymentInvoiceManualBean.setCustomerName(paymentBean.getInputCustomerName());
		paymentInvoiceManualBean.setCustomerAddress(paymentBean.getInputCustomerAddress());
		paymentInvoiceManualBean.setRemark(paymentBean.getInputAdditionalRemark());
		paymentInvoiceManualBean.setCustomerBranch(paymentBean.getInputCustomerBranch());
		
		if(paymentBean.getPaymentBill().size() >=0){
			for(int i=0; i < paymentBean.getPaymentBill().size();i++){
				//PaymentInvoiceManualBean paymentInvoiceManualBean = new PaymentInvoiceManualBean();
				PaymentBillBean paymentBillBean = new PaymentBillBean();
				paymentBillBean = paymentBean.getPaymentBill().get(i);
				paymentInvoiceManualBean.setAmount(paymentBillBean.getInputServiceAmount());
				paymentInvoiceManualBean.setVatAmount(paymentBillBean.getInputsumWt());
				paymentInvoiceManualBean.setQuantity(paymentBillBean.getInputServiceMoreData());
				paymentInvoiceManualBean.setIncometype(paymentBillBean.getInputServiceType());
				paymentInvoiceManualBean.setDiscountbeforvat(paymentBillBean.getInputServiceDiscount());
				paymentInvoiceManualBean.setDiscountspecial(paymentBillBean.getInputSpecialDiscount());
				paymentInvoiceManualBean.setDepartment(paymentBillBean.getInputServiceDepartment());
				paymentInvoiceManualBean.setVatRate(paymentBillBean.getVatrate());
				paymentInvoiceManualBean.setAmounttype(paymentBillBean.getVatRadio());
				
				

			}
			//paymentInvoiceManualDao.insert(paymentInvoiceManualBean);
			}
		
		
		paymentInvoiceManualDao.insert(paymentInvoiceManualBean);
		}
		
		
		
	}
	
	@Override
	public List<PaymentInvoiceManualBean> PaymentInvoiceManualAll() {
		
		
		return null;
	}
	
	
}
