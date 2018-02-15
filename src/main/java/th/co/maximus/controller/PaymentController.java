package th.co.maximus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.service.PaymentService;

@Controller
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/gotoPayment", method = RequestMethod.GET)
	public String registration(Model model) {
		// model.addAttribute("userForm", new User());

		return "payment";
	}
	@RequestMapping(value = "/paymentSuccess", method = RequestMethod.GET)
	public String paymentSuccess(Model model) {
		// model.addAttribute("userForm", new User());

		return "payment-success";
	}
	
	
	
	@RequestMapping(value = "/paymentService", method = RequestMethod.POST)
	@ResponseBody
	public String payment(Model model, @RequestBody PaymentFirstBean paymentBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
		int paymentId = 0;
		try {
			paymentId = paymentService.insert(paymentBean);
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(paymentId>0){
			PaymentResultReq paymentResultReq = new PaymentResultReq();
			paymentResultReq=	paymentService.findByid(paymentId);
			request.setAttribute("paymentResultReq",paymentResultReq);  
		}
		return String.valueOf(paymentId);
	}

}
