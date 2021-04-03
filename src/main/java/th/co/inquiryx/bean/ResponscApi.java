package th.co.inquiryx.bean;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class ResponscApi {
	private String message;
	private List<T> data;
	private List<DropDownBean> roleList;
	private int id;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public List<DropDownBean> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<DropDownBean> roleList) {
		this.roleList = roleList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
