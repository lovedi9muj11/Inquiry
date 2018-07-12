package th.co.maximus.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.core.utils.ReciptNoGenCode;
import th.co.maximus.dao.PaymentOtherManualDao;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.service.PaymentOtherInvoiceManualService;
import th.co.maximus.service.PaymentOtherManualService;
import th.co.maximus.service.PaymentOtherService;
import th.co.maximus.service.TrsmethodOtherManualService;

@Service
public class PaymentOtherServiceImpl implements PaymentOtherService {
	@Autowired
	PaymentOtherManualService paymentOtherManualService;
	@Autowired
	PaymentOtherInvoiceManualService paymentOtherInvoiceManualService;
	@Autowired
	TrsmethodOtherManualService trsmethodOtherManualService;
	@Autowired
	PaymentOtherManualDao paymentOtherManualDao;

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
				
//				if(paymentBean.getUserGroup().equals("1") || paymentBean.getUserGroup().equals("2") ) {
//					if(StringUtils.isNotBlank(paymentBean.getCustName()) ||StringUtils.isNotBlank(paymentBean.getCustAddress() )) {
//						paymentManualBean.setDocType("F");
//					}else {
//						paymentManualBean.setDocType("S");
//					}
//				}else if(paymentBean.getUserGroup().equals("3")) {
//					if(StringUtils.isNotBlank(paymentBean.getCustName()) ||StringUtils.isNotBlank(paymentBean.getCustAddress() ) || StringUtils.isNotBlank(paymentBean.getTaxId())|| StringUtils.isNotBlank(paymentBean.getCustBrach()) ) {
//						paymentManualBean.setDocType("F");
//					}else {
//						paymentManualBean.setDocType("S");
//					}
//				}else {
//					paymentManualBean.setDocType("F");
//				}
//				String code = reciptNoGenCode.genCodeRecipt(paymentManualBean.getDocType());
//				paymentBean.setDocumentNo(code);
				if(paymentBean.getUserGroup().equals("2") || paymentBean.getUserGroup().equals("3") ) {
					if(StringUtils.isNotBlank(paymentBean.getCustName()) &&StringUtils.isNotBlank(paymentBean.getCustAddress() )) {
						paymentManualBean.setDocType("F");
					}else {
						paymentManualBean.setDocType("S");
					}
				}else if(paymentBean.getUserGroup().equals("1")) {
					if(StringUtils.isNotBlank(paymentBean.getCustName()) && StringUtils.isNotBlank(paymentBean.getCustAddress() ) && StringUtils.isNotBlank(paymentBean.getTaxId())&& StringUtils.isNotBlank(paymentBean.getCustBrach()) ) {
						paymentManualBean.setDocType("F");
					}else {
						paymentManualBean.setDocType("S");
					}
				}else {
					paymentManualBean.setDocType("F");
				}
				String code = reciptNoGenCode.genCodeRecipt(paymentManualBean.getDocType());
				paymentBean.setDocumentNo(code);
				paymentBean.setDocType(paymentManualBean.getDocType());


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
	public  PaymentResultReq findByid(int id) throws Exception {
		// TODO Auto-generated method stub
		return paymentOtherManualDao.findById(id);
	}

	@Override
	public List<PaymentResultReq> findListByid(Long id) throws Exception {
		// TODO Auto-generated method stub
		return paymentOtherManualDao.findListById(id);
	}
}
