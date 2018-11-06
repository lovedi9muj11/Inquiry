package th.co.maximus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.model.OfflineResultModel;
import th.co.maximus.service.CancelPaymentService;
import th.co.maximus.service.ClearingPaymentEpisOfflineService;

@Controller
public class ClearingPaymentEpisOffline {
	@Value("${url.online}")
	private String url;

	RestTemplate restTemplate;

	public ClearingPaymentEpisOffline() {
		restTemplate = new RestTemplate();
	}

	@Autowired
	private CancelPaymentService cancelPaymentService;

	@Autowired
	private ClearingPaymentEpisOfflineService clearingPaymentEpisOfflineService;

	@RequestMapping(value = { "/clearing/find" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<PaymentMMapPaymentInvBean> find(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
		result = cancelPaymentService.findAllCancelPayments(creteria.getClearing());
		return result;
	}

	@RequestMapping(value = { "/clearing/save" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void save(@RequestBody PaymentMMapPaymentInvBean creteria) throws Exception {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<>();
		result = cancelPaymentService.findAllCancelPayments(creteria.getClearing());
	
		if (result != null) {
			List<OfflineResultModel> objMessage =clearingPaymentEpisOfflineService.callOnlinePayment(result);
			for (OfflineResultModel offlineResultModel : objMessage) {
				if (offlineResultModel.getStatus().equals("SUCCESS")) {
					
					clearingPaymentEpisOfflineService.updateStatusClearing(offlineResultModel.getManualId(),"Y");
				}else {
					clearingPaymentEpisOfflineService.updateStatusClearing(offlineResultModel.getManualId(),"N");
				}
			}
		}

	}
	
}
