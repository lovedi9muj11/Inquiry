package th.co.maximus.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.ReportTaxRSBean;
import th.co.maximus.service.ReportTaxService;

@Controller
@RequestMapping(value = {"/tax" })
public class ReportTaxController {
	@Autowired
	private ReportTaxService reportTaxService;
	
	@RequestMapping(value = {"/reportRS" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ReportTaxRSBean> paymentPrint(@RequestBody HistoryReportBean creteria) throws SQLException {
		List<ReportTaxRSBean> responeData = new ArrayList<ReportTaxRSBean>();
		responeData = reportTaxService.findPaymentTaxRs(creteria);
		return responeData;
	}

}
