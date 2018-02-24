package th.co.maximus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.service.CancelPaymentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CancelPaymentServiceImpTestCase {

	@Autowired
	private CancelPaymentService cancelPaymentService;
	
	@Test
	public void insertAndUpdateCancelPaymentTestCase() {
		PaymentMMapPaymentInvBean initData = new PaymentMMapPaymentInvBean();
		initData.setManualId(Long.valueOf(1));
		initData.setStatusCancelPayment("02");
		cancelPaymentService.insertAndUpdateCancelPayment(initData);
	}
}
