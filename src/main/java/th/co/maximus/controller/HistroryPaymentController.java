package th.co.maximus.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.bean.HistoryPaymentRS;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.HistorySubFindBean;
import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.service.CancelPaymentService;
import th.co.maximus.service.HistoryPaymentService;

@Controller
public class HistroryPaymentController {
	
	@Autowired
	private HistoryPaymentService paymentManualService;
	
	@Autowired
	private CancelPaymentService cancelPaymentService;
	
	  @RequestMapping(value = {"/gotoHistroryPayment"}, method = RequestMethod.GET)
	    public String gotoHistroryPayment(Model model) {
	        return "history-payment";
	    }
	  
	  @RequestMapping(value = {"/histroryPayment/find"}, method = RequestMethod.POST, produces = "application/json")
	  @ResponseBody
	    public List<PaymentMMapPaymentInvBean> find(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
		  List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
//		  if("".equals(creteria.getAccountNo())) {
//			  result = cancelPaymentService.findAllCancelPayment();	
//		  }else {
		
			  result = paymentManualService.serviceHistroryPaymentFromAccountNo(creteria.getAccountNo());	
			  
//		  }
	        return result;
	    }
	  
	  @RequestMapping(value = {"/histroryPayment/payOrder"}, method = RequestMethod.POST, produces = "application/json")
	  @ResponseBody
	    public List<PaymentMMapPaymentInvBean> payOrder(@RequestBody HistorySubFindBean creteria) {
		  List<PaymentMMapPaymentInvBean> result = new ArrayList<PaymentMMapPaymentInvBean>();
		  if(creteria != null) {
			  result = paymentManualService.findPayOrder(creteria);
		  }
	        return result;
	    }
	  
	  @RequestMapping(value = {"/histroryPayment/paymentPrint"}, method = RequestMethod.POST, produces = "application/json")
	  @ResponseBody
	    public List<HistoryPaymentRS> paymentPrint(@RequestBody HistoryReportBean creteria) throws SQLException {
		  List<HistoryPaymentRS> resultRQ = new ArrayList<HistoryPaymentRS>();
		  List<HistoryPaymentRS> result = new ArrayList<HistoryPaymentRS>();
		
		  if(creteria != null) {
			  
			  resultRQ = paymentManualService.findPaymentOrder(creteria);
			  
			  if(resultRQ.size() > 0) {
				  for(int i=0; i< resultRQ.size();i++) {
					  HistoryPaymentRS hisPay = resultRQ.get(i);
					  BigDecimal reVat = new BigDecimal(107);
					  
					  BigDecimal amount = hisPay.getPaidAmount();
					  BigDecimal vatRQ = amount.multiply(new BigDecimal(hisPay.getVatRate()));
					  BigDecimal vat = vatRQ.divide(reVat,2,RoundingMode.HALF_UP);
					  
					  BigDecimal beforeVat = amount.subtract(vat);
					  
					  hisPay.setVat(vat.setScale(2, RoundingMode.HALF_DOWN));
					  hisPay.setBeforeVat(beforeVat.setScale(2, RoundingMode.HALF_DOWN));
					  hisPay.setPaidAmount(amount.setScale(2, RoundingMode.HALF_DOWN));
					  hisPay.setNumberRun(String.valueOf(i+1));
					  
					  result.add(hisPay);
					  
				  }
				  
			  }
		  }
	        return result;
	    }
	  @RequestMapping(value = {"/histroryPayment/findInvoiceByManualId"}, method = RequestMethod.POST, produces = "application/json")
	  @ResponseBody
	    public PaymentInvoiceManualBean findInvoiceByManualId(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
	        return paymentManualService.findInvoiceManuleByManualIdService(creteria.getManualId());
	    }

}
