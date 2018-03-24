package th.co.maximus.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PaymentMMapPaymentInvBean {
	private Long manualId;
	private Long paymentId;
	private String invoiceNo;
	private String receiptNoManual;
	private Timestamp paidDate;
	private String brancharea;
	private String branchCode;
	private Long paidAmount;
	private String source;
	private String clearing;
	private String remark;
	private String createBy;
	private Timestamp createDate;
	private String recordStatus;
	private BigDecimal beforVat;
	private BigDecimal amount;
	private BigDecimal vatAmount;
	private String period;
	private String accountNo;
	private String payType;
	private String customerName;
	private String paidDateStr;
	private String createDateStr;
	private String statusCancelPayment;
	private String addressNewCancelPayment;
	private String customerAddress;
	
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

	public Timestamp getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Timestamp paidDate) {
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

	public Long getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Long paidAmount) {
		this.paidAmount = paidAmount;
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

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
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
	
}
