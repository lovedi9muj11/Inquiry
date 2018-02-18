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
import th.co.maximus.payment.bean.PaymentOtherFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.service.PaymentOtherService;
@Controller
public class PayOtherController {
	
	@Autowired
	private PaymentOtherService paymentOtherService;
	
	 @RequestMapping(value = {"/payOther"}, method = RequestMethod.GET)
	    public String payOther(Model model) {
	        return "payOther";
	    }
	 
	 
	 @RequestMapping(value = "/paymenOthertService", method = RequestMethod.POST)
		@ResponseBody
		public String payment(Model model, @RequestBody PaymentOtherFirstBean paymentBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
			int paymentId = 0;
			try {
				paymentId = paymentOtherService.insert(paymentBean);
				
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(paymentId>0){
				PaymentResultReq paymentResultReq = new PaymentResultReq();
				paymentResultReq=	paymentOtherService.findByid(paymentId);
				request.setAttribute("paymentResultReq",paymentResultReq);  
			}
			return String.valueOf(paymentId);
		}
	 
}
