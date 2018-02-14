package th.co.maximus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.service.HistoryPaymentService;

@Controller
public class HistroryPaymentController {
	
	@Autowired
	private HistoryPaymentService paymentManualService;
	
	  @RequestMapping(value = {"/gotoHistroryPayment"}, method = RequestMethod.GET)
	    public String gotoHistroryPayment(Model model) {
	        return "history-payment";
	    }
	  
	  @RequestMapping(value = {"/histroryPayment/find"}, method = RequestMethod.POST, produces = "application/json")
	  @ResponseBody
	    public List<PaymentMMapPaymentInvBean> find(@RequestBody PaymentMMapPaymentInvBean creteria) {
		  List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
		  if("".equals(creteria.getAccountNo())) {
			  result = paymentManualService.servicePaymentHitrory();	
		  }else {
			  result = paymentManualService.serviceHistroryPaymentFromAccountNo(creteria.getAccountNo());	
			  
		  }
	        return result;
	    }

}
