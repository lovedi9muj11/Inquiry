package th.co.maximus.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.CasualCustomerBean;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.core.utils.ReciptNoGenCode;
import th.co.maximus.dao.CasualCustomerDao;
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
	
	@Autowired
	CasualCustomerDao casualCustomerDao;

	@Value("${text.prefix}")
	private String nameCode;

	@Override
	public int insert(PaymentOtherFirstBean paymentBean) {

		int paymentId =0;
		
		try {
				PaymentManualBean paymentManualBean = new PaymentManualBean();
				
				if(Constants.VATRATE.NON_VATE.equals(paymentBean.getVatrate())) {
					paymentManualBean.setDocType(Constants.DOCTYPE.RO);
				}else {
					if(paymentBean.getUserGroup().equals(Constants.MasterData.PROPERTY_1.MS_12) || paymentBean.getUserGroup().equals(Constants.MasterData.PROPERTY_1.MS_14) ) {
						if(StringUtils.isNotBlank(paymentBean.getCustName()) &&StringUtils.isNotBlank(paymentBean.getCustAddress() )) {
							paymentManualBean.setDocType(Constants.DOCTYPE.RF);
						}else {
							paymentManualBean.setDocType(Constants.DOCTYPE.RS);
						}
					}else if(paymentBean.getUserGroup().equals(Constants.MasterData.PROPERTY_1.MS_11)) {
						if(StringUtils.isNotBlank(paymentBean.getCustName()) && StringUtils.isNotBlank(paymentBean.getCustAddress() ) && StringUtils.isNotBlank(paymentBean.getTaxId())&& StringUtils.isNotBlank(paymentBean.getCustBrach()) ) {
							paymentManualBean.setDocType(Constants.DOCTYPE.RF);
						}else {
							paymentManualBean.setDocType(Constants.DOCTYPE.RS);
						}
					}else {
						paymentManualBean.setDocType(Constants.DOCTYPE.RF);
					}
				}
				
				String code = reciptNoGenCode.genCodeRecipt(paymentManualBean.getDocType());
				paymentBean.setDocumentNo(code);
				paymentBean.setDocType(paymentManualBean.getDocType());
				
				if(StringUtils.isBlank(paymentBean.getCustNo())) {
					CasualCustomerBean customerBean = new CasualCustomerBean();
					customerBean.setName(paymentBean.getCustName());
					customerBean.setTaxId(paymentBean.getTaxId());
					customerBean.setServiceCode(paymentBean.getUserGroup());
					customerBean.setBranch(paymentBean.getCustBrach());
					customerBean.setAddress(paymentBean.getCustAddress());
					
					saveCasualOther(customerBean);
				}
				
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

	@Override
	public void saveCasualOther(CasualCustomerBean bean) throws Exception {
		if(null == casualCustomerDao.findByTaxId(bean.getTaxId())) {
			casualCustomerDao.insert(bean);
		}else {
			casualCustomerDao.update(bean);
		}
	}

	@Override
	public CasualCustomerBean findCasualByTaxId(String taxId) throws Exception {
		return casualCustomerDao.findByTaxId(taxId);
	}
}
