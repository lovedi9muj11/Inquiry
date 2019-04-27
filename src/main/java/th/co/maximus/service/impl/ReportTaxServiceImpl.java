package th.co.maximus.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.ReportTaxRSBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.dao.ReportTaxDao;
import th.co.maximus.service.ReportTaxService;

@Service
public class ReportTaxServiceImpl implements ReportTaxService{
	@Value("${text.posno}")
	private String posNo;
	
	@Autowired
	private PaymentManualDao paymentManualDao;
	
	@Autowired
	private ReportTaxDao reportTaxDao;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DateTime.DATE_FORMAT);

	@Override
	public List<ReportTaxRSBean> findPaymentTaxRs(HistoryReportBean req) throws SQLException {
		
		List<ReportTaxRSBean> responeData = new ArrayList<ReportTaxRSBean>();
		List<ReportTaxRSBean> listData = new ArrayList<ReportTaxRSBean>();
		ReportTaxRSBean res = new ReportTaxRSBean();
		BigDecimal amount = BigDecimal.ZERO;
		BigDecimal vat = BigDecimal.ZERO;
		BigDecimal beforeVat = BigDecimal.ZERO;
		
		if (req != null) {
			UserProfile profile = (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			Integer supCh = 0;
			
			if(StringUtils.isNotBlank(profile.getUsername())) {
				if(!"".equals(profile.getUsername())) {
					supCh = paymentManualDao.checkSup(profile.getUsername());
				}else {
					supCh = 2;
				}
			}
			
			if(supCh == 2) {
				req.setUnserLogin("");
			}else {
				req.setUnserLogin(profile.getUsername());
			}
			
			listData = reportTaxDao.findPaymentTaxRs(req);
			if (listData.size() > 0) {
				String dateString = "";
				boolean chkreceipt = true;
				int num = 1;
				dateString = dateFormat.format(listData.get(0).getDocumentDate());
				
//				res.setFrom(listData.get(0).getDocumentNo());
//				res.setTo(listData.get(listData.size()-1).getDocumentNo());
				
				for (int i = 0; i < listData.size(); i++) {
					if(dateString.equals(dateFormat.format(listData.get(i).getDocumentDate()))) {
						if(chkreceipt) {
							res.setFrom(listData.get(i).getDocumentNo());
							res.setTo(listData.get(i).getDocumentNo());
							chkreceipt = false;
						}else {
//							res.setTo(listData.get(i).getDocumentNo());
							res.setFrom(listData.get(i).getDocumentNo());
						}
						
						amount = amount.add(listData.get(i).getAmount());
						vat = vat.add(listData.get(i).getVat());
						beforeVat = beforeVat.add(listData.get(i).getAmount().subtract(listData.get(i).getVat()));
						
						res.setQuantity(num+"");
						res.setDocumentDate(listData.get(i).getDocumentDate());
						
					}else {
						res.setVat(vat.setScale(2, RoundingMode.HALF_DOWN));
						res.setBeforeVat(beforeVat.setScale(2, RoundingMode.HALF_DOWN));
						res.setPaidAmount(amount.setScale(2, RoundingMode.HALF_DOWN));
						res.setPosNo(posNo);
						
						responeData.add(res);
						
						res = new ReportTaxRSBean();
						amount = BigDecimal.ZERO;
						vat = BigDecimal.ZERO;
						beforeVat = BigDecimal.ZERO;
						num = 1;
						
						res.setFrom(listData.get(i).getDocumentNo());
						res.setTo(listData.get(i).getDocumentNo());
						
						amount = amount.add(listData.get(i).getAmount());
						vat = vat.add(listData.get(i).getVat());
						beforeVat = beforeVat.add(listData.get(i).getAmount().subtract(listData.get(i).getVat()));
						
						res.setDocumentDate(listData.get(i).getDocumentDate());
						res.setQuantity(num+"");
						
					}
					
					if((i+1) == listData.size()) {
						res.setVat(vat.setScale(2, RoundingMode.HALF_DOWN));
						res.setBeforeVat(beforeVat.setScale(2, RoundingMode.HALF_DOWN));
						res.setPaidAmount(amount.setScale(2, RoundingMode.HALF_DOWN));
						res.setPosNo(posNo);
						
						responeData.add(res);
					}
					
//					res.setNumberRun(String.valueOf(i + 1));
					
					dateString = dateFormat.format(listData.get(i).getDocumentDate());
					num++;
				}
				
//				responeData.add(res);
			}
		}
		
		
		return responeData;
	}

}
