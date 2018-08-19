package th.co.maximus;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import th.co.maximus.bean.HistorySubFindBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.model.PaymentInvoiceEpisOffline;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PaymentHistroryDaoTest {
	
	@Autowired
	 PaymentInvoiceManualDao paymentInvoiceManualDao;
	
	@Autowired
	private PaymentManualDao paymentManualDao;
	
	
	@Test
	@Ignore
	public void findPamentMMapPaymentInV() {
		List<PaymentMMapPaymentInvBean> result = paymentInvoiceManualDao.findPaymentMuMapPaymentInV();
		
		assertThat(result).isNotEmpty();
		
	}
	
	
	@Test
	@Ignore
	public void findPaymentManualFromManualId() {
		List<PaymentManualBean> result = paymentManualDao.findPaymentManualFromNanualId(1);
		
		assertThat(result).isNotEmpty();
	}
	
	@Test
	@Ignore
	public void findHistorySub() throws ParseException {
		HistorySubFindBean historySubFindBean = new HistorySubFindBean();
		String date_s = "20/02/2018 00:00:00.0";
		String date_e = "25/02/2018 00:00:00.0";
		SimpleDateFormat smpA = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		SimpleDateFormat smp = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date dateTo = new java.sql.Date (smp.parse(smp.format(smpA.parse(date_e))).getTime());
		historySubFindBean.setPayDate(new java.sql.Date(smp.parse(smp.format(smpA.parse(date_s))).getTime()));
		historySubFindBean.setPayDateTo(new java.sql.Date(dateTo.getTime()));
		historySubFindBean.setUser("");
		historySubFindBean.setVatRate("");
		historySubFindBean.setPayType("");
		List<PaymentMMapPaymentInvBean> result = paymentInvoiceManualDao.findPayOrder(historySubFindBean);
		
		assertThat(result).isNotEmpty();
	}
	
	@Test
	@Ignore
	public void findByManualId() {
		List<PaymentInvoiceEpisOffline> result = paymentInvoiceManualDao.findByManualId(10);
		
		assertThat(result).isNotEmpty();
		
	}
	
}
