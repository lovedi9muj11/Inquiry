package th.co.maximus.bean;

import java.sql.Timestamp;

public class MasterReceiptHeaderMappingBean {
	private  Long   Id;
	private  String   receiptHeaderMapping;
	private  String   receiptHeader	;
	private  String  remark;
	private  Timestamp  createDate;
	private  String   createBy;
	private  Timestamp   updateDate;
	private  String   updateBy;
	private  String   recordStatus;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getReceiptHeaderMapping() {
		return receiptHeaderMapping;
	}
	public void setReceiptHeaderMapping(String receiptHeaderMapping) {
		this.receiptHeaderMapping = receiptHeaderMapping;
	}
	public String getReceiptHeader() {
		return receiptHeader;
	}
	public void setReceiptHeader(String receiptHeader) {
		this.receiptHeader = receiptHeader;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	
	
}
