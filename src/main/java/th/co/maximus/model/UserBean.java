package th.co.maximus.model;

public class UserBean {
	
	private String surName;
	private String lastName;
	
	public UserBean() {}
	public UserBean(String surName,String lastName) {
		this.surName = surName;
		this.lastName = lastName;
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
	
	

}
