package th.co.maximus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.dao.TrsMethodManualDao;
import th.co.maximus.model.TrsChequerefEpisOffline;
import th.co.maximus.model.TrsCreditrefEpisOffline;
import th.co.maximus.model.TrsMethodEpisOffline;
import th.co.maximus.service.PaymentReportService;
import th.co.maximus.service.TrsChequeRefManualService;
import th.co.maximus.service.TrscreDitrefManualService;

@Service
public class PaymentReportServiceImp implements PaymentReportService {
	
	@Autowired
	private PaymentManualDao paymentManualDao;
	
	@Autowired
	private TrsMethodManualDao trsMethodManualDao;
	
	@Autowired
	private TrscreDitrefManualService trscreDitrefManualService;
	@Autowired
	private TrsChequeRefManualService trsChequeRefManualService;

	@Override
	public List<ReportPaymentBean> findPaymnetReportService(ReportPaymentCriteria criteria,String serviceType) throws Exception {
		
		Integer supCh = paymentManualDao.checkSup(criteria.getUser());
		if(supCh == 2) {
			criteria.setUser("");
		}
		
		String checkWT = "";
		List<ReportPaymentBean> result = paymentManualDao.getReportPayment(criteria,serviceType);
		List<ReportPaymentBean> data = new ArrayList<ReportPaymentBean>();

		for(ReportPaymentBean resultBean : result) {
			String paymentCodeRes = "";
			boolean chkCC = true;
			List<String> results = new ArrayList<>();
			List<TrsMethodEpisOffline> methodResult = trsMethodManualDao.findByManualId(Long.valueOf(resultBean.getManualId()));
				for (int i = 0; i < methodResult.size(); i++) {
					String payCode = "";
					TrsMethodEpisOffline stockObject = (TrsMethodEpisOffline) methodResult.get(i);

					if (stockObject.getCode().equals("CC")) {
						payCode = "เงินสด";
						results.add(payCode);
						if(i==0) {resultBean.setRefNo(""); chkCC=true;}
					} else if (stockObject.getCode().equals("CR")) {
						List<TrsCreditrefEpisOffline> res = trscreDitrefManualService.findByMethodId(stockObject.getId());
						String code = stockObject.getCreditNo();
						payCode = "บัตรเครดิต" + " " + res.get(0).getCardtype() + " " + "เลขที่ : ************" + code.substring(12, 16);
						results.add(payCode);
						if(chkCC) {resultBean.setRefNo(code.substring(12, 16)); chkCC=false;}
					} else if (stockObject.getCode().equals("CH")) {
						List<TrsChequerefEpisOffline> res = trsChequeRefManualService.findTrsCredit(stockObject.getId());
						
						if(CollectionUtils.isNotEmpty(res)) {
							for(int j=0; j<res.size(); j++) {
								payCode = "เช็ค " + res.get(j).getPublisher() + "เลขที่ : ************" + res.get(j).getChequeNo().substring(3);
							}
						}
						
						results.add(payCode);
						if(chkCC) {resultBean.setRefNo("************" + res.get(0).getChequeNo().substring(3)); chkCC=false;}
					}
				}
				for (int i = 0; i < methodResult.size(); i++) {
					TrsMethodEpisOffline stockObject = (TrsMethodEpisOffline) methodResult.get(i);
					if (stockObject.getCode().equals("DEDUC")) {
						checkWT = "WT";
						results.add(checkWT);
					}

				}
				for (int f = 0; f < results.size(); f++) {
					if (f == 0) {
						paymentCodeRes += results.get(f);
					} else {
						paymentCodeRes += " + " + results.get(f);
					}

				}
			resultBean.setPaymentMethod(paymentCodeRes);
			data.add(resultBean);
		}
		
		return data;
	}

}
