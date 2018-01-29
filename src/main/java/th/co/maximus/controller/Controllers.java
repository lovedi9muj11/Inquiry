package th.co.maximus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import th.co.maximus.bean.UserBean;
import th.co.maximus.service.UserService;

@RestController
public class Controllers {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public ModelAndView firstPage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/login")
	public ModelAndView login(String username, String password,HttpServletRequest request) {
		String gotoPage = "";
		
		UserBean bean = userService.authenLogin(username, password);
		
		if(bean.getUserName() != null) {
			request.getSession().setAttribute("userLogin", bean);
			gotoPage = "welcome";
		}else {
			gotoPage = "index";
		}
		return new ModelAndView(gotoPage);
	}


}
