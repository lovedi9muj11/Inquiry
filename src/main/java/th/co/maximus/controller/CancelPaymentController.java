package th.co.maximus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.auth.model.User;
import th.co.maximus.auth.service.UserService;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.UserBean;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.service.CancelPaymentService;

@Controller
public class CancelPaymentController {
	@Autowired
	private CancelPaymentService cancelPaymentService;
	
    @Autowired 
    private PaymentInvoiceManualDao paymentInvoiceManualDao;

    @Autowired 
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @RequestMapping(value = {"/cancalPayment"}, method = RequestMethod.GET)
    public String usermgt(Model model) {
        return "cancel-payment-list";
    }
    
	  @RequestMapping(value = {"/cancelPayment/find"}, method = RequestMethod.POST, produces = "application/json")
	  @ResponseBody
	    public List<PaymentMMapPaymentInvBean> findAll(@RequestBody PaymentMMapPaymentInvBean creteria) {
		  List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
//		  if("".equals(creteria.getAccountNo())) {
			  result = cancelPaymentService.findAllCancelPayment();	
//		  }else {
//			  	
//			  
//		  }
	        return result;
	    }
	  
	  @RequestMapping(value = {"/cancelPayment/checkAuthentication"}, method = RequestMethod.POST, produces = "application/json")
	  @ResponseBody
	    public boolean checkAuthentication(@RequestBody UserBean user) {
		  boolean result = false;
		  if(user.getUserName() != "" && user.getPassword() != "") {
		  
		  }

	        return result;
	    }
}
