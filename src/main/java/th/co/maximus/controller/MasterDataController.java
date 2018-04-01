package th.co.maximus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MasterDataController {

	 @RequestMapping(value = {"/create-master-data"}, method = RequestMethod.GET)
	    public String payOther(Model model) {
	        return "create-master-data";
	    }
	
	 
	
}
