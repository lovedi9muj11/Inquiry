package th.co.maximus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportPaymentController {

	@RequestMapping(value = { "/reportPayment" }, method = RequestMethod.GET)
	public String reportPayment(Model model) {
		return "report-payment";
	}
	
	@RequestMapping(value = { "/reportPaymentTax" }, method = RequestMethod.GET)
	public String reportPaymentTax(Model model) {
		return "report-tax";
	}
}
