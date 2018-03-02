package th.co.maximus.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;
import th.co.maximus.service.PaymentReportService;

@Controller
public class ReportPaymentController {
	
	@Autowired
	private PaymentReportService paymentReportService;

	@RequestMapping(value = { "/reportPayment" }, method = RequestMethod.GET)
	public String reportPayment(Model model) {
		return "report-payment";
	}
	
	@RequestMapping(value = { "/reportPaymentTax" }, method = RequestMethod.GET)
	public String reportPaymentTax(Model model) {
		return "report-tax";
	}
	
	@RequestMapping(value = { "/reportPayment" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ReportPaymentBean> reportPaymentCriteria(@RequestBody ReportPaymentCriteria creteria) {
		List<ReportPaymentBean> result = paymentReportService.findPaymnetReportService(creteria);
		return result;
	}
}
