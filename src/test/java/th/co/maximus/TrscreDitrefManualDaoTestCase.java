package th.co.maximus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import th.co.maximus.bean.TrscreDitrefManualBean;
import th.co.maximus.dao.TrscreDitrefManualDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrscreDitrefManualDaoTestCase {

	@Autowired
	private TrscreDitrefManualDao trscreDitrefManualDao;
	
	@Test
	public void trscreDitrefManualFromManualIdTestCase() {
		List<TrscreDitrefManualBean> result =  trscreDitrefManualDao.trscreDitrefManualFromManualId(1);
		assertThat(result).isEmpty();
	}
} 
