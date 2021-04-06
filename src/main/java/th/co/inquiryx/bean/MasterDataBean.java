package th.co.inquiryx.bean;

import java.util.List;

public class MasterDataBean {
	
	private int id;
	private String value;
	private String text;
	private String group;
	private String masterdataGroup;
	private String keyCode;
	private String type;
	private String score;
	
	private List<MasterDataBean> list;
	
	private List<DropDownBean> DropDownBeans;
	
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
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
	public List<DropDownBean> getDropDownBeans() {
		return DropDownBeans;
	}
	public void setDropDownBeans(List<DropDownBean> dropDownBeans) {
		DropDownBeans = dropDownBeans;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public List<MasterDataBean> getList() {
		return list;
	}
	public void setList(List<MasterDataBean> list) {
		this.list = list;
	}

}
