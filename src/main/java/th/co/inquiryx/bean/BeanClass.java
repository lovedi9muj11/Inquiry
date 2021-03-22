package th.co.inquiryx.bean;

import java.util.Date;

public class BeanClass {
	
	private int id;
	private String name;
	private String sueName;
	private String dateString;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSueName() {
		return sueName;
	}
	public void setSueName(String sueName) {
		this.sueName = sueName;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
