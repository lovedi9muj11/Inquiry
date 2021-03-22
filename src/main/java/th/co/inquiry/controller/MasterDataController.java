package th.co.inquiry.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.inquiry.constants.Constants;
import th.co.inquiry.service.MasterDataService;
import th.co.inquiryx.bean.MasterDataBean;

@Controller
public class MasterDataController {

	@Autowired
	MasterDataService masterDataService;
	
	@RequestMapping(value = { "/create-master-data" }, method = RequestMethod.GET)
	public String createmasterData(Model model) {
		return "create-master-data";
	}

	@RequestMapping(value = { "/create-master-data-group" }, method = RequestMethod.GET)
	public String createGroup(Model model) {
		return "create-master-data-group";
	}
	
	@RequestMapping(value = { "/insertBatch" }, method = RequestMethod.GET)
	public String insertBatch(Model model) {
		return "manageBatch";
	}

	@RequestMapping(value = "/insertMasterdata", method = RequestMethod.POST)
	@ResponseBody
	public String payment(Model model, @RequestBody MasterDataBean masterDataBean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int paymentId = 0;
		try {
			paymentId = masterDataService.insert(masterDataBean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(paymentId);
	}

	@RequestMapping(value = "/insertMasterdataGroup", method = RequestMethod.POST)
	@ResponseBody
	public String insertMasterdataGroup(Model model, @RequestBody MasterDataBean masterDataBean,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		int paymentId = 0;
		try {
			paymentId = masterDataService.insertGroup(masterDataBean);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(paymentId);
	}
	
	@RequestMapping(value = "/findGroupTypeByKeyCode", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public MasterDataBean findGroupTypeByKeyCode(@RequestBody MasterDataBean masterDataBean, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		MasterDataBean masterData = new MasterDataBean();
		try {
			masterData = masterDataService.findGroupTypeByKeyCode(masterDataBean.getGroup());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return masterData;
	}
	
	@RequestMapping(value = "/insertBatch", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String insertBatch(Model model, @RequestBody MasterDataBean masterDataBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String status = Constants.FAIL;
		try {
			masterDataService.insertBatch(masterDataBean);
			status = Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
}
