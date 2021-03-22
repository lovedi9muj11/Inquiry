package th.co.inquiry.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.co.inquiry.auth.model.UserDto;
import th.co.inquiry.auth.model.UserProfile;
import th.co.inquiry.auth.service.UserService;
import th.co.inquiry.constants.Constants;
import th.co.inquiryx.bean.ResponscApi;
import th.co.inquiryx.bean.UserBean;

@RestController
public class UserController {
	
	@Autowired private UserService userService;
	
	@RequestMapping(value = {"/userManageMent/search"}, method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public UserBean search(@RequestBody UserDto user) {
		
		UserDto res = new UserDto();
		List<UserDto> resList = new ArrayList<UserDto>();
		List<UserBean> resultList = new ArrayList<UserBean>();
		
		UserBean userBean = new UserBean();
		
		if("".equals(user.getUsername())) {
			resList = userService.findAll();
		} else {
			res = userService.findByUsername(user.getUsername());
			resList.add(res);
		}
		
		for(int i=0; i<resList.size(); i++) {
			String roleCode = "";
			String roleId = "";
			UserBean result = new UserBean();
			result.setId(resList.get(i).getId());
			result.setUserName(resList.get(i).getUsername());
			result.setName(resList.get(i).getName());
			result.setSurName(resList.get(i).getSurname());
			for(int j=0; j<resList.get(i).getRoles().size(); j++) {
				roleCode += resList.get(i).getRoles().get(j).getName() + " ";
				roleId = resList.get(i).getRoles().get(j).getId().toString();
			}
			result.setRoleCode(roleCode);
			result.setIdRole(Integer.valueOf(roleId));
			resultList.add(result);
		}
		
		userBean.setUserBeans(resultList);
		
		return userBean;
	}
	
	@RequestMapping(value = "/userManageMent/save", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponscApi save(@RequestBody UserBean user, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponscApi responscApi = new ResponscApi();
		String status = Constants.FAIL;
		try {
			UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			userService.save(user, profile.getUsername());
			status = Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		responscApi.setMessage(status);

		return responscApi;
	}
	
	@RequestMapping(value = {"/userManageMent/getRole"}, method = RequestMethod.GET)
    public ResponscApi getRole() throws Exception {
		ResponscApi responscApi = new ResponscApi();
		String status = Constants.FAIL;
		try {
			responscApi.setRoleList(userService.getRoles());
			userService.getRoles();
			status = Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		responscApi.setMessage(status);
		
        return responscApi;
    }
	
	@RequestMapping(value = "/userManageMent/delete", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponscApi delete(@RequestBody UserBean user, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResponscApi responscApi = new ResponscApi();
		String status = Constants.FAIL;
		try {
			UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			userService.delete(user, profile.getUsername());
			status = Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		responscApi.setMessage(status);

		return responscApi;
	}
	
}
