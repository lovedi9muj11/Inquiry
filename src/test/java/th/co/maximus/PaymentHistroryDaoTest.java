package th.co.maximus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.dao.PaymentManualDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PaymentHistroryDaoTest {
	
	@Autowired
	 PaymentInvoiceManualDao paymentInvoiceManualDao;
	
	@Autowired
	private PaymentManualDao paymentManualDao;
	
	
	@Test
	public void findPamentMMapPaymentInV() {
		List<PaymentMMapPaymentInvBean> result = paymentInvoiceManualDao.findPaymentMuMapPaymentInV();
		
		assertThat(result).isNotEmpty();
		
	}
	
	
	@Test
	public void findPaymentManualFromManualId() {
		List<PaymentManualBean> result = paymentManualDao.findPaymentManualFromNanualId(1);
		
		assertThat(result).isNotEmpty();
	}
}
