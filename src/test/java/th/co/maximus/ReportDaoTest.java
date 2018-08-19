package th.co.maximus;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.dao.ReportDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ReportDaoTest {
	
	@Autowired
	ReportDao reportDao;

	@Test
	@Ignore
	public void inqueryEpisOfflineJSONHandler() {
		try {
			reportDao.inqueryEpisOfflineJSONHandler("EPF011704S1808130009");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void inqueryEpisOfflineOtherJSONHandler() {
		try {
			reportDao.inqueryEpisOfflineOtherJSONHandler("EPF011704S1808130009");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void inqueryInvPaymentOrderTaxBeanJSONHandler() {
		HistoryReportBean creteria = new HistoryReportBean();
		creteria.setTypePrint("EPF011704S1808130009");
		try {
			reportDao.inqueryInvPaymentOrderTaxBeanJSONHandler(creteria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
