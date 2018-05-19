package th.co.maximus.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.dao.TrsMethodManualDao;
import th.co.maximus.model.TrsMethodEpisOffline;
import th.co.maximus.service.PaymentReportService;

@Service
public class PaymentReportServiceImp implements PaymentReportService {
	
	@Autowired
	private PaymentManualDao paymentManualDao;
	
	@Autowired
	private TrsMethodManualDao trsMethodManualDao;
	
	@Autowired
	private PaymentInvoiceManualDao paymentInvoiceManualDao;

	@Override
	public List<ReportPaymentBean> findPaymnetReportService(ReportPaymentCriteria criteria) throws Exception {
		List<ReportPaymentBean> result = paymentManualDao.getReportPayment(criteria);
		for(ReportPaymentBean resultBean : result) {
			List<TrsMethodEpisOffline> methodResult = trsMethodManualDao.findByManualId(Long.valueOf(resultBean.getManualId()));
			StringBuffer paymentMethod = new StringBuffer();
			for(TrsMethodEpisOffline method: methodResult) {
				paymentMethod.append(method.getName()+" ");
			}
			resultBean.setPaymentMethod(paymentMethod.toString());
		}
		
	     Collections.sort(result, new Comparator<ReportPaymentBean>(){
				@Override
				public int compare(ReportPaymentBean o1, ReportPaymentBean o2) {
					return o2.getCreateDate().compareTo(o1.getCreateDate());
				}
	        });
		return result;
	}

}
