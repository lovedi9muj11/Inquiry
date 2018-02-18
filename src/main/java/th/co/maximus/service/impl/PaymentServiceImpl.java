package th.co.maximus.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.core.utils.ReciptNoGenCode;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.service.PaymentInvoiceManualService;
import th.co.maximus.service.PaymentManualService;
import th.co.maximus.service.PaymentService;
import th.co.maximus.service.TrsmethodManualService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired PaymentManualService paymentManualService;
	@Autowired PaymentInvoiceManualService paymentInvoiceManualService;
	@Autowired TrsmethodManualService trsmethodManualService;
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
	public int insert(PaymentFirstBean paymentBean) {
		int paymentId =0;
		int code = reciptNoGenCode.genCodeRecipt();
		try {
				PaymentManualBean paymentManualBean = new PaymentManualBean();
				if(paymentBean.getBalanceSum()>= paymentBean.getBalanceSummary()){
					paymentManualBean.setPaytype("F");
				}else{
					paymentManualBean.setPaytype("P");
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
				String dateS = sdf.format(new Date());
				
				String dates=convertDateString(dateS);

				 
				String zeron = "";
				if(code >9) {
					zeron ="00"+code;
				}else {
					zeron ="000"+code;
				}
				String codeName = nameCode+posNo+branArea + paymentManualBean.getPaytype()+dates+zeron;		
				paymentBean.setDocumentNo(codeName);

			
			
			
			paymentId = paymentManualService.insertPaymentManual(paymentBean);
			if(paymentId>0){
				paymentInvoiceManualService.insertPaymentInvoiceManual(paymentBean, paymentId);
				trsmethodManualService.insertTrsmethodManual(paymentBean, paymentId);
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
