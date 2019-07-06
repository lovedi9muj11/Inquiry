package th.co.maximus.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
	
	@Value("${text.posname}")
	private String posName;
	
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
			if (CollectionUtils.isNotEmpty(listData)) {
				String dateString = "";
				boolean chkreceipt = true;
				int num = 1;
				int numQuantity = 0;
				int numRow = 1;
				String vatRate = listData.get(0).getVatRate()+"";
				String vatBefore = listData.get(0).getVatRate()+"";
				dateString = dateFormat.format(listData.get(0).getDocumentDate());
				
//				res.setFrom(listData.get(0).getDocumentNo());
//				res.setTo(listData.get(listData.size()-1).getDocumentNo());
				
				for (int i = 0; i < listData.size(); i++) {
					if(vatRate.equals(listData.get(i).getVatRate()+"")) {
						vatRate = listData.get(i).getVatRate()+" % ";
					}else {
						if(!vatBefore.equals(listData.get(i).getVatRate()+"")) {
							vatRate = vatRate.concat((listData.get(i).getVatRate()+" % "));
						}
					}
					vatBefore = listData.get(i).getVatRate()+"";
					
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
						res.setDocumentDateStr(dateFormat.format(listData.get(i).getDocumentDate()));
						
					}else {
						res.setVat(vat.setScale(2, RoundingMode.HALF_DOWN));
						res.setVatStr(vat.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setBeforeVat(beforeVat.setScale(2, RoundingMode.HALF_DOWN));
						res.setBeforeVatStr(beforeVat.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setPaidAmount(amount.setScale(2, RoundingMode.HALF_DOWN));
						res.setPaidAmountStr(amount.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setPosName(posName);
						
						res.setNumberRun(""+(numRow));
						numQuantity += Integer.parseInt(res.getQuantity());
						responeData.add(res);
						numRow++;
						
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
						res.setVatStr(vat.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setBeforeVat(beforeVat.setScale(2, RoundingMode.HALF_DOWN));
						res.setBeforeVatStr(beforeVat.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setPaidAmount(amount.setScale(2, RoundingMode.HALF_DOWN));
						res.setPaidAmountStr(amount.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setPosName(posName);
						
						res.setNumberRun(""+(numRow));
						numQuantity += Integer.parseInt(res.getQuantity());
						res.setQuantitySummery(numQuantity+" ฉบับ");
						res.setVatRateStr(vatRate);
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

	@Override
	public ReportTaxRSBean findPaymentTaxRsReport(HistoryReportBean req) throws SQLException {
		
		List<ReportTaxRSBean> responeData = new ArrayList<ReportTaxRSBean>();
		ReportTaxRSBean resData = new ReportTaxRSBean();
		List<ReportTaxRSBean> listData = new ArrayList<ReportTaxRSBean>();
		ReportTaxRSBean res = new ReportTaxRSBean();
		BigDecimal amount = BigDecimal.ZERO;
		BigDecimal vat = BigDecimal.ZERO;
		BigDecimal beforeVat = BigDecimal.ZERO;
		BigDecimal afterSummery = BigDecimal.ZERO;
		BigDecimal vatSummery = BigDecimal.ZERO;
		BigDecimal beforeVatSummery = BigDecimal.ZERO;
		String numQuantitys = "";
		String vatRate = "";
		
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
			if (CollectionUtils.isNotEmpty(listData)) {
				String dateString = "";
				boolean chkreceipt = true;
				int num = 1;
				int numQuantity = 0;
				int numRow = 1;
				vatRate = listData.get(0).getVatRate()+"";
				String vatBefore = listData.get(0).getVatRate()+"";
				dateString = dateFormat.format(listData.get(0).getDocumentDate());
				
//				res.setFrom(listData.get(0).getDocumentNo());
//				res.setTo(listData.get(listData.size()-1).getDocumentNo());
				
				for (int i = 0; i < listData.size(); i++) {
					if(vatRate.equals(listData.get(i).getVatRate()+"")) {
						vatRate = listData.get(i).getVatRate()+" % ";
					}else {
						if(!vatBefore.equals(listData.get(i).getVatRate()+"")) {
							vatRate = vatRate.concat((listData.get(i).getVatRate()+" % "));
						}
					}
					vatBefore = listData.get(i).getVatRate()+"";
					
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
						res.setDocumentDateStr(dateFormat.format(listData.get(i).getDocumentDate()));
						
					}else {
						res.setVat(vat.setScale(2, RoundingMode.HALF_DOWN));
						vatSummery = vatSummery.add(vat);
						res.setVatStr(vat.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setBeforeVat(beforeVat.setScale(2, RoundingMode.HALF_DOWN));
						beforeVatSummery = beforeVatSummery.add(beforeVat);
						res.setBeforeVatStr(beforeVat.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setPaidAmount(amount.setScale(2, RoundingMode.HALF_DOWN));
						afterSummery = afterSummery.add(amount);
						res.setPaidAmountStr(amount.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setPosName(posName);
						
						res.setNumberRun(""+(numRow));
						numQuantity += Integer.parseInt(res.getQuantity());
						responeData.add(res);
						numRow++;
						
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
						vatSummery = vatSummery.add(vat);
						res.setVatStr(vat.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setBeforeVat(beforeVat.setScale(2, RoundingMode.HALF_DOWN));
						beforeVatSummery = beforeVatSummery.add(beforeVat);
						res.setBeforeVatStr(beforeVat.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setPaidAmount(amount.setScale(2, RoundingMode.HALF_DOWN));
						afterSummery = afterSummery.add(amount);
						res.setPaidAmountStr(amount.setScale(2, RoundingMode.HALF_DOWN).toString());
						res.setPosName(posName);
						
						res.setNumberRun(""+(numRow));
						numQuantity += Integer.parseInt(res.getQuantity());
						res.setQuantitySummery(numQuantity+" ฉบับ");
						numQuantitys = numQuantity+" ฉบับ";
						res.setVatRateStr(vatRate);
						responeData.add(res);
					}
					
//					res.setNumberRun(String.valueOf(i + 1));
					
					dateString = dateFormat.format(listData.get(i).getDocumentDate());
					num++;
				}
				
//				responeData.add(res);
			}
		}
		
		resData.setReportTaxRSBeanList(responeData);
		resData.setVatRateStr(vatRate);
		resData.setQuantitySummery(numQuantitys);
		resData.setBeforVatSummery(beforeVatSummery.setScale(2, RoundingMode.HALF_DOWN).toString());
		resData.setVatSummery(vatSummery.setScale(2, RoundingMode.HALF_DOWN).toString());
		resData.setAfterVatSummery(afterSummery.setScale(2, RoundingMode.HALF_DOWN).toString());
		return resData;
	}

}
