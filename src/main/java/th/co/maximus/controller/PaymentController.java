package th.co.maximus.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.core.utils.Utils;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.service.PaymentService;

@Controller
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/gotoPayment", method = RequestMethod.GET)
	public String registration() {
	
		return "payment";
	}
	@RequestMapping(value = "/paymentSuccess", method = RequestMethod.GET)
	public String paymentSuccess(Model model,int idUser,HttpServletRequest request) throws Exception {
		PaymentResultReq paymentResultReq = new PaymentResultReq();
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy"); 
		Utils utils = new Utils();
		if(idUser>0){
			paymentResultReq=	paymentService.findByid(idUser);
			paymentResultReq.setBalanceSummary(paymentResultReq.getBalanceSummary().setScale(2, RoundingMode.HALF_DOWN));
			paymentResultReq.setBalanceOfvat(paymentResultReq.getBalanceOfvat().setScale(2, RoundingMode.HALF_DOWN));
			paymentResultReq.setVat(paymentResultReq.getVat().setScale(2, RoundingMode.HALF_DOWN));
			paymentResultReq.setBeforeVat(paymentResultReq.getBeforeVat().setScale(2, RoundingMode.HALF_DOWN));
			if(paymentResultReq.getDeduction() == null) {
				paymentResultReq.setDeduction(new BigDecimal(0).setScale(2, RoundingMode.HALF_DOWN));
			}else {
				paymentResultReq.setDeduction(paymentResultReq.getDeduction().setScale(2, RoundingMode.HALF_DOWN));
			}
			
			
			paymentResultReq.setBalancePrice(paymentResultReq.getBalanceOfvat().setScale(2, RoundingMode.HALF_DOWN).subtract(paymentResultReq.getBalanceSummary().setScale(2, RoundingMode.HALF_DOWN)));
			paymentResultReq.setPeriod(utils.periodFormat(paymentResultReq.getPeriod()));
			
			Date date =  paymentResultReq.getInvoiceDate();
			String invoiceDate = dt.format(date);
			
			Date dateLineDate =  paymentResultReq.getDateLine();
			String dateLineSt = dt.format(dateLineDate);
			
			paymentResultReq.setInvoiceDateRS(invoiceDate);
			paymentResultReq.setDateLineRS(dateLineSt);
			
			request.setAttribute("paymentResultReq",paymentResultReq);  
		}
		
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
		return String.valueOf(paymentId);
	}

}
