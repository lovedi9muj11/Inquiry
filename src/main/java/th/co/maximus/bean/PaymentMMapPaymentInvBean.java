package th.co.maximus.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import th.co.maximus.core.utils.converter.CustomDateTimeSerializer;
import th.co.maximus.core.utils.converter.CustomDateTimeDeserializer;

public class PaymentMMapPaymentInvBean {
	private Long manualId;
	private Long paymentId;
	private String invoiceNo;
	private String receiptNoManual;
	private Date paidDate;
	private String brancharea;
	private String branchCode;
	private BigDecimal paidAmount;
	private String source;
	private String clearing;
	private String remark;
	private String createBy;
	private Date createDate;
	private String recordStatus;
	private BigDecimal beforVat;
	private BigDecimal beforVatOther;
	private BigDecimal amount;
	private BigDecimal amountOther;
	private BigDecimal vatAmount;
	private BigDecimal vatAmountOther;
	private String period;
	private String accountNo;
	private String payType;
	private String customerName;
	private String paidDateStr;
	private String createDateStr;
	private String statusCancelPayment;
	private String addressNewCancelPayment;
	private String customerAddress;
	private String paymentMethod;
	private String serviceType;
	
	private String chkPaymentType;
	private boolean chkCancel;
	private String serviceName;
	private String customerGroup;
	private String customerGroupName;
	private String userApproved;
	private BigDecimal discountBeforVat;
	private BigDecimal discountSpecial;
	private String reasonCode;
	private String reasonDesc;
	private String branchAreaCode;
	private Date clearingDate;
	private String clearingDateStr;
	private String cancleDate;
	private String cancelflag;
	private String cancleBy;
	
	//---- joey WAwow 30/05/2020
	private String departmentArea;
	private String segmentOther;
	private String productOther;
	
	
	
	
	

	public String getDepartmentArea() {
		return departmentArea;
	}

	public void setDepartmentArea(String departmentArea) {
		this.departmentArea = departmentArea;
	}

	public String getSegmentOther() {
		return segmentOther;
	}

	public void setSegmentOther(String segmentOther) {
		this.segmentOther = segmentOther;
	}

	public String getProductOther() {
		return productOther;
	}

	public void setProductOther(String productOther) {
		this.productOther = productOther;
	}

	public String getCancleBy() {
		return cancleBy;
	}

	public void setCancleBy(String cancleBy) {
		this.cancleBy = cancleBy;
	}

	public String getCancelflag() {
		return cancelflag;
	}

	public void setCancelflag(String cancelflag) {
		this.cancelflag = cancelflag;
	}

	public String getCancleDate() {
		return cancleDate;
	}

	public void setCancleDate(String cancleDate) {
		this.cancleDate = cancleDate;
	}

	public String getBranchAreaCode() {
		return branchAreaCode;
	}

	public void setBranchAreaCode(String branchAreaCode) {
		this.branchAreaCode = branchAreaCode;
	}

	public String getAddressNewCancelPayment() {
		return addressNewCancelPayment;
	}

	public void setAddressNewCancelPayment(String addressNewCancelPayment) {
		this.addressNewCancelPayment = addressNewCancelPayment;
	}

	public String getStatusCancelPayment() {
		return statusCancelPayment;
	}

	public void setStatusCancelPayment(String statusCancelPayment) {
		this.statusCancelPayment = statusCancelPayment;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigDecimal getBeforVat() {
		return beforVat;
	}

	public void setBeforVat(BigDecimal beforVat) {
		this.beforVat = beforVat;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getPaidDateStr() {
		return paidDateStr;
	}

	public void setPaidDateStr(String paidDateStr) {
		this.paidDateStr = paidDateStr;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Long getManualId() {
		return manualId;
	}

	public void setManualId(Long manualId) {
		this.manualId = manualId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getPaidDate() {
		return paidDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public String getBrancharea() {
		return brancharea;
	}

	public void setBrancharea(String brancharea) {
		this.brancharea = brancharea;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
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
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getCreateDate() {
		return createDate;
	}
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getChkPaymentType() {
		return chkPaymentType;
	}

	public void setChkPaymentType(String chkPaymentType) {
		this.chkPaymentType = chkPaymentType;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public boolean isChkCancel() {
		return chkCancel;
	}

	public void setChkCancel(boolean chkCancel) {
		this.chkCancel = chkCancel;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}

	public String getUserApproved() {
		return userApproved;
	}

	public void setUserApproved(String userApproved) {
		this.userApproved = userApproved;
	}

	public BigDecimal getDiscountBeforVat() {
		return discountBeforVat;
	}

	public void setDiscountBeforVat(BigDecimal discountBeforVat) {
		this.discountBeforVat = discountBeforVat;
	}

	public BigDecimal getDiscountSpecial() {
		return discountSpecial;
	}

	public void setDiscountSpecial(BigDecimal discountSpecial) {
		this.discountSpecial = discountSpecial;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getReasonDesc() {
		return reasonDesc;
	}

	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

	public String getCustomerGroupName() {
		return customerGroupName;
	}

	public void setCustomerGroupName(String customerGroupName) {
		this.customerGroupName = customerGroupName;
	}

	public BigDecimal getBeforVatOther() {
		return beforVatOther;
	}

	public void setBeforVatOther(BigDecimal beforVatOther) {
		this.beforVatOther = beforVatOther;
	}

	public BigDecimal getAmountOther() {
		return amountOther;
	}

	public void setAmountOther(BigDecimal amountOther) {
		this.amountOther = amountOther;
	}

	public BigDecimal getVatAmountOther() {
		return vatAmountOther;
	}

	public void setVatAmountOther(BigDecimal vatAmountOther) {
		this.vatAmountOther = vatAmountOther;
	}

	public Date getClearingDate() {
		return clearingDate;
	}

	public void setClearingDate(Date clearingDate) {
		this.clearingDate = clearingDate;
	}

	public String getClearingDateStr() {
		return clearingDateStr;
	}

	public void setClearingDateStr(String clearingDateStr) {
		this.clearingDateStr = clearingDateStr;
	}
	
	
}
