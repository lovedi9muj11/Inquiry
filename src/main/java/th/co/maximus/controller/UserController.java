package th.co.maximus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import th.co.maximus.auth.model.User;
import th.co.maximus.auth.service.UserService;

@Controller
public class UserController {
	
	@Autowired private UserService userService;
	
	@RequestMapping(value = {"/userManageMent/search"}, method = RequestMethod.POST)
    public String search(@RequestBody User user) {
		userService.findByUsername("");
        return "userManageMent";
    }

}
