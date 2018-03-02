package th.co.maximus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.service.PaymentReportService;

@Service
public class PaymentReportServiceImp implements PaymentReportService {
	
	@Autowired
	private PaymentManualDao paymentManualDao;

	@Override
	public List<ReportPaymentBean> findPaymnetReportService(ReportPaymentCriteria criteria) {
			
		return paymentManualDao.getReportPayment(criteria);
	}

}
