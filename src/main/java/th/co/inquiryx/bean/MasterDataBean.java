package th.co.inquiryx.bean;

import java.util.List;

public class MasterDataBean {
	
	private int id;
	private String value;
	private String text;
	private String group;
	private String orderBatch;
	private String masterdataGroup;
	private String property2;
	private String keyCode;
	private String property1;
	
	private String month;
	private String day;
	private String hour;
	private String flagH;
	private String flagM;
	private String minute;
	
	private String yearNow;
	private String monthNow;
	
	private List<DropDownBean> DropDownBeans;
	private List<DropDownBean> DropDownMonths; 
	
	
	
	public String getProperty1() {
		return property1;
	}
	public void setProperty1(String property1) {
		this.property1 = property1;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getProperty2() {
		return property2;
	}
	public void setProperty2(String property2) {
		this.property2 = property2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getMasterdataGroup() {
		return masterdataGroup;
	}
	public void setMasterdataGroup(String masterdataGroup) {
		this.masterdataGroup = masterdataGroup;
	}
	public String getOrderBatch() {
		return orderBatch;
	}
	public void setOrderBatch(String orderBatch) {
		this.orderBatch = orderBatch;
	}
	public List<DropDownBean> getDropDownBeans() {
		return DropDownBeans;
	}
	public void setDropDownBeans(List<DropDownBean> dropDownBeans) {
		DropDownBeans = dropDownBeans;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getMinute() {
		return minute;
	}
	public void setMinute(String minute) {
		this.minute = minute;
	}
	public List<DropDownBean> getDropDownMonths() {
		return DropDownMonths;
	}
	public void setDropDownMonths(List<DropDownBean> dropDownMonths) {
		DropDownMonths = dropDownMonths;
	}
	public String getYearNow() {
		return yearNow;
	}
	public void setYearNow(String yearNow) {
		this.yearNow = yearNow;
	}
	public String getMonthNow() {
		return monthNow;
	}
	public void setMonthNow(String monthNow) {
		this.monthNow = monthNow;
	}
	public String getFlagH() {
		return flagH;
	}
	public void setFlagH(String flagH) {
		this.flagH = flagH;
	}
	public String getFlagM() {
		return flagM;
	}
	public void setFlagM(String flagM) {
		this.flagM = flagM;
	}
	

}
