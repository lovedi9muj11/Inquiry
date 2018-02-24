package th.co.maximus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import th.co.maximus.bean.TrsChequeRefManualBean;
import th.co.maximus.dao.TrsChequeRefManualDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TrsChequeRefManualDaoTestCase {

	@Autowired
	private TrsChequeRefManualDao trsChequeRefManualDao;
	
	@Test
	public void findTrachequeFromManualIdTestCase() {
		List<TrsChequeRefManualBean> result = trsChequeRefManualDao.findTrachequeFromManualId(1);
		assertThat(result).isEmpty();
		
	}
}
