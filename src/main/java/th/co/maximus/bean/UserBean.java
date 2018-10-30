package th.co.maximus.bean;

import java.util.ArrayList;
import java.util.List;

public class UserBean {
	
	private Long id;
	private String name;
	private String surName;
	private String userName;
	private String password;
	private String passwordConfirm;
	private String roleCode;
	private String loginFlag;
	
	List<UserBean> userBeans = new ArrayList<UserBean>();
	private String centerServiceName;
	
	// bean
	private Principal principal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public Principal getPrincipal() {
		return principal;
	}
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	public List<UserBean> getUserBeans() {
		return userBeans;
	}
	public void setUserBeans(List<UserBean> userBeans) {
		this.userBeans = userBeans;
	}
	public String getCenterServiceName() {
		return centerServiceName;
	}
	public void setCenterServiceName(String centerServiceName) {
		this.centerServiceName = centerServiceName;
	}
	
}
