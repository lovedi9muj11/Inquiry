package th.co.maximus.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.bean.HistoryPaymentRS;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.HistorySubFindBean;
import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.service.ClearingPaymentEpisOfflineService;
import th.co.maximus.service.HistoryPaymentService;

@Controller
public class HistroryPaymentController {

	@Autowired
	private HistoryPaymentService paymentManualService;

	@Autowired
	private ClearingPaymentEpisOffline clearingPaymentEpisOffline;

	@Autowired
	private ClearingPaymentEpisOfflineService clearingPaymentEpisOfflineService;

	// @Autowired
	// private CancelPaymentService cancelPaymentService;
	
	@Autowired
	private PaymentManualDao paymentManualDao;

	@RequestMapping(value = { "/gotoHistroryPayment" }, method = RequestMethod.GET)
	public String gotoHistroryPayment(Model model) {
		return "history-payment";
	}
	
	@RequestMapping(value = { "/gotoHistroryPaymentother" }, method = RequestMethod.GET)
	public String gotoHistroryPaymentother(Model model) {
		return "history-payment-other";
	}

	@RequestMapping(value = { "/histroryPayment/find" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<PaymentMMapPaymentInvBean> find(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
		// if("".equals(creteria.getAccountNo())) {
		// result = cancelPaymentService.findAllCancelPayment();
		// }else {

		result = paymentManualService.serviceHistroryPaymentFromAccountNo(creteria.getAccountNo(), "IBACSS");

		// }
		return result;
	}
	
	@RequestMapping(value = { "/histroryPaymentByother/find" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<PaymentMMapPaymentInvBean> findByother(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
		// if("".equals(creteria.getAccountNo())) {
		// result = cancelPaymentService.findAllCancelPayment();
		// }else {

		result = paymentManualService.serviceHistroryPaymentFromAccountNo(creteria.getAccountNo(),"OTHER");

		// }
		return result;
	}

	@RequestMapping(value = { "/histroryPayment/payOrder" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<PaymentMMapPaymentInvBean> payOrder(@RequestBody HistorySubFindBean creteria) {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<PaymentMMapPaymentInvBean>();
		if (creteria != null) {
			result = paymentManualService.findPayOrder(creteria);
		}
		return result;
	}

	@RequestMapping(value = {"/histroryPayment/paymentPrint" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<HistoryPaymentRS> paymentPrint(@RequestBody HistoryReportBean creteria) throws SQLException {
		List<HistoryPaymentRS> resultRQ = new ArrayList<HistoryPaymentRS>();
		List<HistoryPaymentRS> result = new ArrayList<HistoryPaymentRS>();

		if (creteria != null) {

			resultRQ = paymentManualService.findPaymentOrder(creteria);

			if (resultRQ.size() > 0) {
				for (int i = 0; i < resultRQ.size(); i++) {
					HistoryPaymentRS hisPay = resultRQ.get(i);
					BigDecimal reVat = new BigDecimal(107);

					BigDecimal amount = hisPay.getPaidAmount();
					BigDecimal vatRQ = amount.multiply(new BigDecimal(hisPay.getVatRate()));
					BigDecimal vat = vatRQ.divide(reVat, 2, RoundingMode.HALF_UP);

					BigDecimal beforeVat = amount.subtract(vat);

					hisPay.setVat(vat.setScale(2, RoundingMode.HALF_DOWN));
					hisPay.setBeforeVat(beforeVat.setScale(2, RoundingMode.HALF_DOWN));
					hisPay.setPaidAmount(amount.setScale(2, RoundingMode.HALF_DOWN));
					hisPay.setNumberRun(String.valueOf(i + 1));
					hisPay.setVatRate(hisPay.getVatRate());

					result.add(hisPay);

				}

			}
		}
		return result;
	}

	@RequestMapping(value = {"/histroryPayment/findInvoiceByManualId" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public PaymentInvoiceManualBean findInvoiceByManualId(@RequestBody PaymentMMapPaymentInvBean creteria)
			throws Exception {
		return paymentManualService.findInvoiceManuleByManualIdService(creteria.getManualId());
	}
	
	@RequestMapping(value = {"/histroryPayment/findInvoiceByManualIdCancel" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public PaymentManualBean findInvoiceByManualIdCancel(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
		List<PaymentManualBean> paymentManual = paymentManualDao.findPaymentManualFromNanualId(creteria.getManualId());
		return paymentManual.get(0);
//		return paymentManualService.findInvoiceManuleByManualIdService(creteria.getManualId());
	}

	@RequestMapping(value = { "/histroryPayment/clearing" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public HashMap<String, String> clearing(@RequestBody List<PaymentMMapPaymentInvBean> creteria) throws Exception {
		String message = "";
		HashMap<String, String> result = new HashMap<>();
		try {
			String messages = clearingPaymentEpisOfflineService.callOnlinePayment(creteria);
			if (!messages.equals("N")) {
				for (PaymentMMapPaymentInvBean payment : creteria) {
					clearingPaymentEpisOfflineService.updateStatusClearing(payment.getManualId());
				}
				message = "success :"+message;
			}else{
				message = "error :"+message;
			}
			
		} catch (Exception e) {
			message = "error" + e.getMessage();
		}
		result.put("data", message);
		return result;
	}

}
