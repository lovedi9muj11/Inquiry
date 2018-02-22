package th.co.maximus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import th.co.maximus.bean.TrsMethodManualBean;
import th.co.maximus.dao.TrsMethodManualDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrsMethodManualDaoTestCase {
	@Autowired
	private TrsMethodManualDao trsMethodManualDao;
	
	@Test
	public void findTrsMethodManualFromManualIdTestCase() {
		List<TrsMethodManualBean> result = trsMethodManualDao.findTrsMethodManualFromManualId(1);
		assertThat(result).isNotEmpty();
	}
}
