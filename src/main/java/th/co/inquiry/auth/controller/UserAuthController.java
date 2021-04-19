package th.co.inquiry.auth.controller;

import java.util.ArrayList;
import java.util.List;

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

import th.co.inquiry.auth.model.UserDto;
import th.co.inquiry.auth.model.UserProfile;
import th.co.inquiry.auth.repository.UserRepository;
import th.co.inquiry.auth.service.SecurityService;
import th.co.inquiry.auth.service.UserService;
import th.co.inquiry.auth.validator.UserValidator;
import th.co.inquiry.constants.Constants;
import th.co.inquiry.service.MasterDataService;
import th.co.inquiryx.bean.MasterDataBean;
import th.co.inquiryx.bean.UserBean;

@Controller
public class UserAuthController {
	
    @Autowired private UserService userService;

    @Autowired private SecurityService securityService;

    @Autowired private UserValidator userValidator;
    
    @Autowired private UserRepository userRepository;
    
    @Autowired private MasterDataService masterDataService;;

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
		
    	UserDto user = userRepository.findByUsername(userPro.getUsername());
    	String lgFlag = userPro.getLoginFlag();
    	if(null!=user)lgFlag = user.getLoginFlag();
    	if(Constants.USER.LOGIN_FLAG_Y.equalsIgnoreCase(lgFlag)) {
    		return "confirm-password";
    	}else {
    		setReport(model);
    		return "welcome";
    	}
    }
	
	@RequestMapping(value = {"/afterpassword", "/welcomePassword"}, method = RequestMethod.GET)
    public String welcomePassword(Model model) {
		setReport(model);
		return "welcome";
    }
    
    @RequestMapping(value = {"/userManageMent"}, method = RequestMethod.GET)
    public String usermgt(Model model) {
    	setReport(model);
        return "userManageMent";
    }
    
    @RequestMapping(value = {"/masterData"}, method = RequestMethod.GET)
    public String masterData(Model model) {
    	setReport(model);
        return "master-data";
    }
   
    public void addUserSession(UserBean user, HttpSession session) {
    	session.setAttribute("userRole", user.getRoleCode());
    }
    
    @RequestMapping(value = "/checkPassword", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkPassword(Model model, @RequestBody UserBean userBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	boolean chkResponse = true;
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
    
    @RequestMapping(value = "/change-password", method = RequestMethod.GET)
    public String changePassword(Model model) throws Exception {
    	setReport(model);
    	return "confirm-password";
    }
    
    @RequestMapping(value = {"/questionReport"}, method = RequestMethod.GET)
    public String page1(Model model) {
    	setReport(model);
        return "questionReport";
    }
    
    @RequestMapping(value = {"/report0"}, method = RequestMethod.GET)
    public String report0(Model model) {
    	setReport(model);
    	return "report0";
    }
    
    @RequestMapping(value = {"/report1"}, method = RequestMethod.GET)
    public String report1(Model model) {
    	setReport(model);
    	return "report1";
    }
    
    @RequestMapping(value = {"/report2"}, method = RequestMethod.GET)
    public String report2(Model model) {
    	setReport(model);
    	return "report2";
    }
    
    @RequestMapping(value = {"/report3"}, method = RequestMethod.GET)
    public String report3(Model model) {
    	setReport(model);
    	return "report3";
    }
    
    @RequestMapping(value = {"/report4"}, method = RequestMethod.GET)
    public String report4(Model model) {
    	setReport(model);
    	return "report4";
    }
    
    @RequestMapping(value = {"/report5"}, method = RequestMethod.GET)
    public String report5(Model model) {
    	setReport(model);
    	return "report5";
    }
    
    @RequestMapping(value = {"/question"}, method = RequestMethod.GET)
    public String page2(Model model) {
    	setReport(model);
        return "question";
    }
    
    @RequestMapping(value = {"/score"}, method = RequestMethod.GET)
    public String page3(Model model) {
    	setReport(model);
    	return "score";
    }
    
    void setReport(Model model) {
    	List<MasterDataBean> masterDataBeans = new ArrayList<MasterDataBean>();
		masterDataBeans = masterDataService.findQuestionByGroupKey(Constants.QUESTION_REPORT);
		model.addAttribute("msData", masterDataBeans);
    }
    
}
