package th.co.maximus.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.bean.TmpInvoiceBean;
import th.co.maximus.core.utils.ReciptNoGenCode;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.service.PaymentInvoiceManualService;
import th.co.maximus.service.PaymentManualService;
import th.co.maximus.service.PaymentService;
import th.co.maximus.service.TmpInvoiceService;
import th.co.maximus.service.TrsmethodManualService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired PaymentManualService paymentManualService;
	@Autowired PaymentInvoiceManualService paymentInvoiceManualService;
	@Autowired TrsmethodManualService trsmethodManualService;
	@Autowired PaymentManualDao paymentManualDao;
	@Autowired TmpInvoiceService tmpInvoiceService;
	@Autowired
	ReciptNoGenCode reciptNoGenCode;
	
	@Value("${text.prefix}")
	private String nameCode;
	@Value("${text.posno}")
	private String posNo;
	@Value("${text.branarea}")
	private String branArea;
	
	@Override
	public int insert(PaymentFirstBean paymentBean) {
		int paymentId =0;
		
		try {
				PaymentManualBean paymentManualBean = new PaymentManualBean();
				
				if(paymentBean.getUserGroup().equals("1") || paymentBean.getUserGroup().equals("2") ) {
					if(StringUtils.isNotBlank(paymentBean.getCustName()) ||StringUtils.isNotBlank(paymentBean.getCustAddress() )) {
						paymentManualBean.setDocType("F");
					}else {
						paymentManualBean.setDocType("S");
					}
				}else if(paymentBean.getUserGroup().equals("3")) {
					if(StringUtils.isNotBlank(paymentBean.getCustName()) ||StringUtils.isNotBlank(paymentBean.getCustAddress() ) || StringUtils.isNotBlank(paymentBean.getTaxId())|| StringUtils.isNotBlank(paymentBean.getCustBrach()) ) {
						paymentManualBean.setDocType("F");
					}else {
						paymentManualBean.setDocType("S");
					}
				}else {
					paymentManualBean.setDocType("F");
				}
				String code = reciptNoGenCode.genCodeRecipt(paymentManualBean.getDocType());
				paymentBean.setDocumentNo(code);


			paymentId = paymentManualService.insertPaymentManual(paymentBean);
			if(paymentId>0){
				paymentInvoiceManualService.insertPaymentInvoiceManual(paymentBean, paymentId);
				trsmethodManualService.insertTrsmethodManual(paymentBean, paymentId);
				
				
				TmpInvoiceBean tmpInvoiceBean = new TmpInvoiceBean();
				Date date = new Date();
				UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String period = "";
				if(paymentBean.getStartupDate() != null && paymentBean.getEndDate() != null) {
					String[] sResult = paymentBean.getStartupDate().split("-");
					String[] eResult = paymentBean.getEndDate().split("-");
					
					String start = sResult[0]+sResult[1]+sResult[2];
					String end = eResult[0]+eResult[1]+eResult[2];
					
					 period = start+end;
					}
				tmpInvoiceBean.setManualId(paymentId);
				tmpInvoiceBean.setInvoiceNo(paymentBean.getInvoiceNo());
				tmpInvoiceBean.setInvoiceDate(paymentBean.getInvoiceDate());
				tmpInvoiceBean.setBeforVat(new BigDecimal(paymentBean.getBalanceBeforeTax()));
				tmpInvoiceBean.setVatAmount(new BigDecimal(paymentBean.getVat()));
				
				double resRQ = (paymentBean.getBalanceSum()+ (paymentBean.getSummaryTax() * -1));
				if(resRQ > paymentBean.getBalanceOfTax()) {
					tmpInvoiceBean.setPaidAmount(new BigDecimal(paymentBean.getBalanceOfTax()));
				}else {
					tmpInvoiceBean.setPaidAmount(new BigDecimal(resRQ));
				}
				tmpInvoiceBean.setChange(new BigDecimal(paymentBean.getChang()));
				tmpInvoiceBean.setAmount(new BigDecimal(paymentBean.getAmountInvoice()));
				tmpInvoiceBean.setVatRate(paymentBean.getVatrate());
				tmpInvoiceBean.setCustomerName(paymentBean.getCustName());
				tmpInvoiceBean.setCustomerAddress(paymentBean.getCustAddress());
				tmpInvoiceBean.setCustomerSegment("1");
				tmpInvoiceBean.setCustomerBranch(paymentBean.getCustBrach());
				tmpInvoiceBean.setTaxno(paymentBean.getTaxId());
				tmpInvoiceBean.setAccountSubNo(paymentBean.getServiceNo());
				tmpInvoiceBean.setPeriod(period);
				tmpInvoiceBean.setCreateBy(profile.getUsername());
				tmpInvoiceBean.setCreateDate(new Timestamp(date.getTime()));
				tmpInvoiceBean.setUpdateBy(profile.getUsername());
				tmpInvoiceBean.setUpdateDate(new Timestamp(date.getTime()));
				tmpInvoiceBean.setRecordStatus("A");
				if(paymentBean.getTaxOnly() == null) {
					tmpInvoiceBean.setDiscount(0.00);
				}else {
					tmpInvoiceBean.setDiscount(paymentBean.getTaxOnly());
				}
				
				tmpInvoiceService.insertTmpInvoice(tmpInvoiceBean);
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
	public void update(PaymentFirstBean paymentBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaymentResultReq findByid(int id) throws Exception{
		// TODO Auto-generated method stub
		return paymentManualDao.findById(id);
	}

	@Override
	public PaymentResultReq findIdGenCode(int id) throws Exception {
		// TODO Auto-generated method stub
		return paymentManualDao.findById(id);
	}

	public static final String convertDateString(String str) {
		return str.replaceAll("([0-9]{2})/([0-9]{2})/([0-9]{4})", "$3-$2-$1");

	}
}
