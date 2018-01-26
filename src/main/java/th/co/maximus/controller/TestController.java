package th.co.maximus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import th.co.maximus.bean.UserBean;
import th.co.maximus.service.UserService;

@RestController
public class TestController {
	
	@Autowired UserService userService;
	
	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<UserBean> all() {
		return userService.selectAll();
	}

}
