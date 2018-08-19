package th.co.maximus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import th.co.maximus.dao.PaymentOtherManualDao;
import th.co.maximus.payment.bean.PaymentResultReq;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PaymentOtherManualDaoTestCase {
	
	@Autowired
	PaymentOtherManualDao paymentOtherManualDao;

	@Test
	@Ignore
	public void findById() {
		PaymentResultReq result = new PaymentResultReq();
		try {
			result = paymentOtherManualDao.findById(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(result.getManualId()).isNotNull();
	}
	
	@Test
	@Ignore
	public void findListById() {
		List<PaymentResultReq> result = new ArrayList<PaymentResultReq>();
		try {
			result = paymentOtherManualDao.findListById(1L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertThat(result).isNotEmpty();
	}

}
