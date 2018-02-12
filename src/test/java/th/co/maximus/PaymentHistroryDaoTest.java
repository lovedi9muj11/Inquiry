package th.co.maximus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.dao.PaymentInvoiceManualDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class PaymentHistroryDaoTest {
	
	@Autowired
	private PaymentInvoiceManualDao paymentInvoiceManualDao;
	
	@Test
	public void findPamentMMapPaymentInV() {
		List<PaymentMMapPaymentInvBean> result = paymentInvoiceManualDao.findPaymentMuMapPaymentInV();
		
		assertThat(result).isNotEmpty();
		
	}
}
