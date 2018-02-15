package th.co.maximus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.payment.bean.PaymentTaxBean;
import th.co.maximus.payment.bean.PaymentTranPriceBean;
import th.co.maximus.service.PaymentInvoiceManualService;
import th.co.maximus.service.PaymentManualService;
import th.co.maximus.service.PaymentService;
import th.co.maximus.service.TrsmethodManualService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PaymentSeriveTest{
	
	@Autowired PaymentManualService paymentManualService;
	@Autowired PaymentInvoiceManualService paymentInvoiceManualService;
	@Autowired TrsmethodManualService trsmethodManualService;
	@Autowired PaymentService paymentService;
	
	@Ignore
	@Test
	@Rollback
	public void savePaymentMunal() {
		PaymentFirstBean paymentBean = new PaymentFirstBean();

		paymentBean.setInvoiceNo("1234");
		paymentBean.setRemark("INSERT");
		paymentBean.setCustName("CUSTNAME");
		paymentBean.setCustName("19 / 11 ต.หนองน้ำใส");
		
		paymentManualService.insertPaymentManual(paymentBean);
	}
	
	@Ignore
	@Test
	@Rollback
	public void savePaymentInvoiceMunal() {
		PaymentFirstBean paymentBean = new PaymentFirstBean();

		paymentBean.setInvoiceNo("1234");
		paymentBean.setRemark("INSERT");
		paymentBean.setCustName("CUSTNAME");
		paymentBean.setCustName("19 / 11 ต.หนองน้ำใส");
		
		paymentInvoiceManualService.insertPaymentInvoiceManual(paymentBean, 0);
	}
	@Ignore
	@Test
	@Rollback
	public void saveTrsMethod() {
		PaymentFirstBean paymentBean = new PaymentFirstBean();
		PaymentTaxBean paymentTaxBean = new PaymentTaxBean();
		Date date = new Date();
		List<PaymentTranPriceBean> result = new ArrayList<PaymentTranPriceBean>();
		List<PaymentTaxBean> resultTaxBean = new ArrayList<PaymentTaxBean>();
		PaymentTranPriceBean tbean = new PaymentTranPriceBean();
		
		paymentBean.setInvoiceNo("1234");
		paymentBean.setRemark("INSERT");
		paymentBean.setCustName("CUSTNAME");
		paymentBean.setCustName("19 / 11 ต.หนองน้ำใส");
		tbean.setTypePayment("CH");
		tbean.setCheckNo("E445454");
		tbean.setCreditType("VISA");
		tbean.setMoneyTran(500);
		tbean.setBankName("");
		tbean.setBankNo("");
		tbean.setBranchCheck("");
		tbean.setCreditPrice(500);
		tbean.setDateCheck(new Timestamp(date.getTime()));
		paymentTaxBean.setInvoiceNo("1234");
		paymentTaxBean.setDocDed("DFDSF44");
		paymentTaxBean.setMoneyDed(500);
		paymentTaxBean.setRadioDed("96T");
		resultTaxBean.add(paymentTaxBean);
		result.add(tbean);
		paymentBean.setPaymentTranPrice(result);
		paymentBean.setPaymentTax(resultTaxBean);
		
		trsmethodManualService.insertTrsmethodManual(paymentBean,55);
	}
	@Test
	@Rollback
	public void findById() throws Exception {
		PaymentResultReq bean = new PaymentResultReq();
		bean = paymentService.findByid(16);
		System.out.println(bean);
	}

}
