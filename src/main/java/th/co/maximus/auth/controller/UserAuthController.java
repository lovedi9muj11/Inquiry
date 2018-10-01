package th.co.maximus.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.co.maximus.auth.model.UserDto;
import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.auth.service.SecurityService;
import th.co.maximus.auth.service.UserService;
import th.co.maximus.auth.validator.UserValidator;
import th.co.maximus.bean.UserBean;
import th.co.maximus.constants.Constants;

@Controller
public class UserAuthController {
	
    @Autowired private UserService userService;

    @Autowired private SecurityService securityService;

    @Autowired private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDto());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout,HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
            SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
			securityContextLogoutHandler.logout(request, response, auth);

        return "login";
    }

    
	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	UserProfile userPro = (UserProfile) auth.getPrincipal();
		
    	if(Constants.USER.LOGIN_FLAG_Y.equalsIgnoreCase(userPro.getLoginFlag())) {
    		return "confirm-password";
    	}else {
    		return "welcome";
    	}
    }
	
	@RequestMapping(value = {"/afterpassword", "/welcomePassword"}, method = RequestMethod.GET)
    public String welcomePassword(Model model) {
		return "welcome";
    }
    
    @RequestMapping(value = {"/userManageMent"}, method = RequestMethod.GET)
    public String usermgt(Model model) {
        return "userManageMent";
    }
    
    @RequestMapping(value = {"/masterData"}, method = RequestMethod.GET)
    public String masterData(Model model) {
        return "master-data";
    }
   
    public void addUserSession(UserBean user, HttpSession session) {
    	session.setAttribute("userRole", user.getRoleCode());
    }
    
    @RequestMapping(value = "/checkPassword", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkPassword(Model model, @RequestBody UserBean userBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
//    	Map<String, Object> params = new HashMap<String, Object>();
    	boolean chkResponse = true;
//    	JSONObject jo = new JSONObject();
    	UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	chkResponse = userService.checkPassword(userBean.getPassword(), profile.getUsername());
		return chkResponse;
	}
    
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
	public Boolean updatePassword(Model model, @RequestBody UserBean userBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	userService.saveConfirmPassword(userBean, profile.getUsername());
    	boolean res = true;
		return res;
	}
    
}
