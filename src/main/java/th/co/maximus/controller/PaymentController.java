package th.co.maximus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import th.co.maximus.auth.model.User;

@Controller
public class PaymentController {
	 @RequestMapping(value = "/gotoPayment", method = RequestMethod.GET)
	    public String registration(Model model) {
//	        model.addAttribute("userForm", new User());

	        return "payment";
	    }
}
