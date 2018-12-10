package th.co.maximus.model;

public class UserBean {
	
	private String surName;
	private String lastName;
	private Long roleId;
	
	public UserBean() {}
	public UserBean(String surName,String lastName,Long roleId) {
		this.surName = surName;
		this.lastName = lastName;
		this.roleId = roleId;
	}

	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	

}
