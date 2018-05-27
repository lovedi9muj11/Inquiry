package th.co.maximus.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.auth.model.Role;
import th.co.maximus.auth.model.UserDto;
import th.co.maximus.auth.service.UserService;
import th.co.maximus.bean.InvEpisOfflineReportBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.bean.UserBean;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.service.CancelPaymentService;
import th.co.maximus.service.ReportService;
import th.co.maximus.service.report.PaymentReport;

@Controller
public class CancelPaymentController {
	@Autowired
	private CancelPaymentService cancelPaymentService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentManualDao paymentManualDao;
	
	@Autowired
	private PaymentReport paymentReport;
	
	@Autowired
	ReportService reportService;

	@RequestMapping(value = { "/cancalPayment" }, method = RequestMethod.GET)
	public String usermgt(Model model) {
		return "cancel-payment-list";
	}

	@RequestMapping(value = { "/cancelPayment/find" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<PaymentMMapPaymentInvBean> findAll(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
		if (!"".equals(creteria.getReceiptNoManual()) || !"".equals(creteria.getInvoiceNo())) {
			result = cancelPaymentService.serviceCriteriaFromInvoiceOrReceiptNo(creteria.getReceiptNoManual(),
					creteria.getInvoiceNo());
		} else {
			result = cancelPaymentService.findAllCancelPayment();
		}
		return result;
	}

	@RequestMapping(value = { "/cancelPayment/findFromId" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<PaymentMMapPaymentInvBean> findAllFromId(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
		if (!("").equals(creteria.getManualId())) {
			result = cancelPaymentService.findAllCancelPaymentFromId(creteria.getManualId());
		}
		return result;
	}

	@RequestMapping(value = {"/cancelPayment/checkAuthentication" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int checkAuthentication(@RequestBody UserBean user) {
		int result = 0;
		boolean checkRole = false;
		if (user.getUserName() != "" && user.getPassword() != "") {
			UserDto resultUser = userService.findByUsername(user.getUserName());
			for(Role role :resultUser.getRoles()) {
				if("sup".equals(role.getName())) {
					checkRole = true;
					break;
				}
			}
			if (resultUser != null && checkRole) {
				if (bCryptPasswordEncoder.matches(user.getPassword(), resultUser.getPassword())) {
					result = 0;
				}else {
					result = 2;
				}
			}else {
				result = 1;
			}
		}
		return result;
	}

	@RequestMapping(value = {"/cancelPayment/updateStatus" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int cancelPayment(@RequestBody PaymentMMapPaymentInvBean creteria) {
		return cancelPaymentService.insertAndUpdateCancelPayment(creteria);
	}
	
	@RequestMapping(value = { "/reportCancelPaymentPDF" }, method = RequestMethod.POST)
		public void reportCancelPaymentPDF(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 String JASPER_JRXML_FILENAME = "InvEpisPayment";
			request.setAttribute("documentReport", "-1");
			 List<PaymentManualBean> getReceiptNo = paymentManualDao.findPaymentManualFromNanualId(Long.valueOf(request.getParameter("receiptNo")));
			 List<InvEpisOfflineReportBean> collections = reportService.inqueryEpisOfflineJSONHandler(getReceiptNo.get(0).getReceiptNoManual());
			 paymentReport.previewEpisOffilneprint(request, response, collections, JASPER_JRXML_FILENAME);
	        
		}
	
}
