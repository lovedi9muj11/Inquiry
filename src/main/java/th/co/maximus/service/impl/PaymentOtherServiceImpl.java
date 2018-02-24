package th.co.maximus.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.core.utils.ReciptNoGenCode;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.service.PaymentOtherInvoiceManualService;
import th.co.maximus.service.PaymentOtherManualService;
import th.co.maximus.service.PaymentOtherService;
import th.co.maximus.service.TrsmethodOtherManualService;
@Service
public class PaymentOtherServiceImpl implements PaymentOtherService{
	@Autowired PaymentOtherManualService paymentOtherManualService;
	@Autowired PaymentOtherInvoiceManualService paymentOtherInvoiceManualService;
	@Autowired TrsmethodOtherManualService trsmethodOtherManualService;
	@Autowired PaymentManualDao paymentManualDao;

	@Autowired
	ReciptNoGenCode reciptNoGenCode;
	
	@Value("${text.prefix}")
	private String nameCode;
	@Value("${text.posno}")
	private String posNo;
	@Value("${text.branarea}")
	private String branArea;
	
	@Override
	public int insert(PaymentOtherFirstBean paymentBean) {
		
		
int paymentId =0;
		
		try {
				PaymentManualBean paymentManualBean = new PaymentManualBean();
				
				if(paymentBean.getUserGroup().equals("01") || paymentBean.getUserGroup().equals("02") ) {
					if(StringUtils.isNotBlank(paymentBean.getInputCustomerName()) ||StringUtils.isNotBlank(paymentBean.getInputCustomerAddress() )) {
						paymentManualBean.setDocType("F");
					}else {
						paymentManualBean.setDocType("S");
					}
				}else if(paymentBean.getUserGroup().equals("03")) {
					if(StringUtils.isNotBlank(paymentBean.getInputCustomerName()) ||StringUtils.isNotBlank(paymentBean.getInputCustomerAddress() ) || StringUtils.isNotBlank(paymentBean.getInputCustomerTaxNo())|| StringUtils.isNotBlank(paymentBean.getInputCustomerBranch()) ) {
						paymentManualBean.setDocType("F");
					}else {
						paymentManualBean.setDocType("S");
					}
				}
				String code = reciptNoGenCode.genCodeRecipt(paymentManualBean.getDocType());
				paymentBean.setDocumentNo(code);


			paymentId = paymentOtherManualService.insertPaymentManual(paymentBean);
			if(paymentId>0){
				paymentOtherInvoiceManualService.insertPaymentInvoiceManual(paymentBean, paymentId);
				trsmethodOtherManualService.insertTrsmethodManual(paymentBean, paymentId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return paymentId;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PaymentOtherFirstBean paymentBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaymentResultReq findByid(int id) throws Exception{
		// TODO Auto-generated method stub
		return paymentManualDao.findById(id);
	}
}
