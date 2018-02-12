package th.co.maximus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.payment.bean.PaymentFirstBean;

@Controller
public class PaymentController {
	 @RequestMapping(value = "/gotoPayment", method = RequestMethod.GET)
	    public String registration(Model model) {
//	        model.addAttribute("userForm", new User());

	        return "payment";
	    }
	 
	 
	 @RequestMapping(value = "/paymentService", method = RequestMethod.POST)
	 @ResponseBody
	    public String payment(Model model,@RequestBody PaymentFirstBean paymentBean) {
		 
		 

	        return "payment";
	    }
	 
}
