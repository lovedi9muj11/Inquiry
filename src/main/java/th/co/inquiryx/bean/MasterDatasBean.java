package th.co.inquiryx.bean;

import java.util.List;

public class MasterDatasBean {
	private Long id;
	private String keyCode;
	private String value;
	private String groupKey;
	private String type;
	private String status;
	private String ordered;
	private String parentId;
	private String refId;
	private String property1;
	private String property2;
	private String property3;
	private String property4;
	private String property5;
	private String remark;
	private String recordStatus;
	
	private List<MasterDatasBean> usergroup;
	private List<MasterDatasBean> usergroupOther;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getGroupKey() {
		return groupKey;
	}
	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrdered() {
		return ordered;
	}
	public void setOrdered(String ordered) {
		this.ordered = ordered;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getProperty1() {
		return property1;
	}
	public void setProperty1(String property1) {
		this.property1 = property1;
	}
	public String getProperty2() {
		return property2;
	}
	public void setProperty2(String property2) {
		this.property2 = property2;
	}
	public String getProperty3() {
		return property3;
	}
	public void setProperty3(String property3) {
		this.property3 = property3;
	}
	public String getProperty4() {
		return property4;
	}
	public void setProperty4(String property4) {
		this.property4 = property4;
	}
	public String getProperty5() {
		return property5;
	}
	public void setProperty5(String property5) {
		this.property5 = property5;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public List<MasterDatasBean> getUsergroup() {
		return usergroup;
	}
	public void setUsergroup(List<MasterDatasBean> usergroup) {
		this.usergroup = usergroup;
	}
	public List<MasterDatasBean> getUsergroupOther() {
		return usergroupOther;
	}
	public void setUsergroupOther(List<MasterDatasBean> usergroupOther) {
		this.usergroupOther = usergroupOther;
	}
	

}
