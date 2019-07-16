package th.co.maximus.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import th.co.maximus.core.utils.converter.CustomDateDeserializer;
import th.co.maximus.core.utils.converter.CustomDateSerializer;

public class PaymentDTO {
	private Long paymenId;
	private String invoiceNo;
	private String receiptNoManual;
	private BigDecimal vatAmount;
	private Date paidDate;
	private String branchArea;
	private String branchCode;
	private BigDecimal paidAmount;
	private String remark;
	private String source;
	private String clearing;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	private String recordStatus;
	private String accountNo;
	private Long ManualId;
	
	//offline
	private String branchName;
	private String userName;
	private String posNo;
	private Long officerId;
	private String userLogin;
	private String posId;
	private String paidDateStr;
	private String branchAreaCode;
	
	
	
	
	public String getBranchAreaCode() {
		return branchAreaCode;
	}
	public void setBranchAreaCode(String branchAreaCode) {
		this.branchAreaCode = branchAreaCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPosNo() {
		return posNo;
	}
	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}
	public Long getOfficerId() {
		return officerId;
	}
	public void setOfficerId(Long officerId) {
		this.officerId = officerId;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getPosId() {
		return posId;
	}
	public void setPosId(String posId) {
		this.posId = posId;
	}
	public Long getPaymenId() {
		return paymenId;
	}
	public void setPaymenId(Long paymenId) {
		this.paymenId = paymenId;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getReceiptNoManual() {
		return receiptNoManual;
	}
	public void setReceiptNoManual(String receiptNoManual) {
		this.receiptNoManual = receiptNoManual;
	}
	public BigDecimal getVatAmount() {
		return vatAmount;
	}
	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getPaidDate() {
		return paidDate;
	}

	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public String getBranchArea() {
		return branchArea;
	}
	public void setBranchArea(String branchArea) {
		this.branchArea = branchArea;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getClearing() {
		return clearing;
	}
	public void setClearing(String clearing) {
		this.clearing = clearing;
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
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Long getManualId() {
		return ManualId;
	}
	public void setManualId(Long manualId) {
		ManualId = manualId;
	}
	public String getPaidDateStr() {
		return paidDateStr;
	}
	public void setPaidDateStr(String paidDateStr) {
		this.paidDateStr = paidDateStr;
	}
	
	
	
	
}
