package th.co.inquiryx.bean;

import java.util.Date;

public class MapGLBean {
	
	private Long id;
	private String glCode;
	private String serviceCode;
	private String serviceName;
	private String productCode;
	private String productName;
	private String subProductCode;
	private String subProductName;
	private String revenueTypeCode;
	private String revenueTypeName;
	private String segMentCode;
	private String segMentName;
	private String erpInterfaceFlag;
	private String status;
	private String remark;
	private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String recordStatus;
    private String source;

	public String getErpInterfaceFlag() {
		return erpInterfaceFlag;
	}

	public void setErpInterfaceFlag(String erpInterfaceFlag) {
		this.erpInterfaceFlag = erpInterfaceFlag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGlCode() {
		return glCode;
	}

	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSubProductCode() {
		return subProductCode;
	}

	public void setSubProductCode(String subProductCode) {
		this.subProductCode = subProductCode;
	}

	public String getSubProductName() {
		return subProductName;
	}

	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}

	public String getRevenueTypeCode() {
		return revenueTypeCode;
	}

	public void setRevenueTypeCode(String revenueTypeCode) {
		this.revenueTypeCode = revenueTypeCode;
	}

	public String getRevenueTypeName() {
		return revenueTypeName;
	}

	public void setRevenueTypeName(String revenueTypeName) {
		this.revenueTypeName = revenueTypeName;
	}

	public String getSegMentCode() {
		return segMentCode;
	}

	public void setSegMentCode(String segMentCode) {
		this.segMentCode = segMentCode;
	}

	public String getSegMentName() {
		return segMentName;
	}

	public void setSegMentName(String segMentName) {
		this.segMentName = segMentName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
