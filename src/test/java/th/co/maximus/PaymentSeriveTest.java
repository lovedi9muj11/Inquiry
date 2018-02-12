package th.co.maximus;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.dao.PaymentManualDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentSeriveTest {
	
	@Autowired PaymentManualDao paymentManualDao;
	
	Date date = new Date();
	
	@Test
	public void save() {
		PaymentManualBean paymentManualBean = new PaymentManualBean();
			paymentManualBean.setInvoiceNo("111111");
			paymentManualBean.setReceiptNoManual("");
			paymentManualBean.setPaidDate(new Timestamp(date.getTime()));
			paymentManualBean.setBrancharea("CAT นนทบุรี");
			paymentManualBean.setBranchCode("001");
			paymentManualBean.setPaidAmount(555);
			paymentManualBean.setSource("OFFLINE");
			paymentManualBean.setClearing("N");
			paymentManualBean.setRemark("");
			paymentManualBean.setCreateBy("ADMIN");
			paymentManualBean.setCreateDate(new Timestamp(date.getTime()));
			paymentManualBean.setUpdateBy("ADMIN");
			paymentManualBean.setUpdateDate(new Timestamp(date.getTime()));
			paymentManualBean.setRecordStatus("A");
			paymentManualBean.setAccountNo("asdasdasd");
		paymentManualDao.insertPayment(paymentManualBean);
	}
	
	

}
