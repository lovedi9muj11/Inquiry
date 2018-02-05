package th.co.maximus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.co.maximus.auth.model.User;
import th.co.maximus.auth.service.UserService;
import th.co.maximus.bean.UserBean;

@RestController
public class UserController {
	
	@Autowired private UserService userService;
	

	@RequestMapping(value = {"/userManageMent/search"}, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public List<UserBean> search(@RequestBody User user) {

//		model.addAttribute("userForm", userService.findByUsername(user.getUsername()));
		User res = new User();
		List<User> resList = new ArrayList<User>();
		List<UserBean> resultList = new ArrayList<UserBean>();
		
		if("".equals(user.getUsername())) {resList = userService.findAll();}
		else {res = userService.findByUsername(user.getUsername());resList.add(res);}
		
		for(int i=0; i<resList.size(); i++) {
			UserBean result = new UserBean();
			result.setId(resList.get(i).getId());
			result.setUserName(resList.get(i).getUsername());
			result.setPassword(resList.get(i).getPassword());
			result.setRoleCode("");
			
			resultList.add(result);
		}
		
      return resultList;
    }
}
