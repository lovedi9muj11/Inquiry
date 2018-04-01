package th.co.maximus.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.auth.model.GroupTypeDropdown;
import th.co.maximus.service.MasterDataService;

import th.co.maximus.bean.MasterDataBean;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.auth.model.GroupTypeDropdown;
import th.co.maximus.service.MasterDataService;


@Controller
public class MasterDataController {
	
	@Autowired
	MasterDataService masterDataService;
	
	 @RequestMapping(value = {"/create-master-data"}, method = RequestMethod.GET)
	    public String payOther(Model model) {
	        return "create-master-data";
	    }
	

	 @RequestMapping(value = {"/masterData/selectAll"}, method = RequestMethod.GET, produces = "application/json")
		@ResponseBody
	    public List<GroupTypeDropdown> masterData() {
			
	      return masterDataService.findAll();
	    }
	
	 @RequestMapping(value = {"/masterData/selectAll"}, method = RequestMethod.GET, produces = "application/json")
		@ResponseBody
	    public List<GroupTypeDropdown> masterData() {
			
	      return masterDataService.findAll();
	    }
	 @RequestMapping(value = "/insertMasterdata", method = RequestMethod.POST)
		@ResponseBody
		public String payment(Model model, @RequestBody MasterDataBean paymentBean,HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			return "";
		}
	
}
