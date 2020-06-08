package th.co.maximus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.bean.CasualCustomerBean;
import th.co.maximus.service.CasualCustomerService;

@Controller
@RequestMapping(value = {"/other/"})
public class OtherCustomerController {
	
	@Autowired CasualCustomerService casualCustomerService;

	@RequestMapping(value = {"customer"}, method = RequestMethod.GET)
    public String otherPage(Model model) {
        return "other_customer";
    }
	
	@RequestMapping(value = {"find" }, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<CasualCustomerBean> findByother(@RequestBody CasualCustomerBean creteria) throws Exception {
		List<CasualCustomerBean> result = new ArrayList<CasualCustomerBean>();
		result = casualCustomerService.findByNameTaxId(creteria);
		
		return result;
	}
		
	}
