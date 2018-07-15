package th.co.maximus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.auth.model.GroupTypeDropdown;
import th.co.maximus.service.MasterDataService;

import th.co.maximus.bean.MasterDataBean;
import th.co.maximus.constants.Constants;

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

	@RequestMapping(value = { "/masterData/selectAll" }, method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<GroupTypeDropdown> masterData() {

		return masterDataService.findAll();
	}
	
	@RequestMapping(value = { "/masterData/masterDataBatch" }, method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<GroupTypeDropdown> masterDataBatch() {
		
		return masterDataService.findBatch(Constants.MasterData.TRIGGER_GOUP);
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
	
	@RequestMapping(value = "/findAllMasterData", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<MasterDataBean> findAllMasterData(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MasterDataBean> masterDataList = new ArrayList<MasterDataBean>();
		try {
			masterDataList = masterDataService.showAllMSNGL();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return masterDataList;
	}

}
