package th.co.maximus.bean;

import java.math.BigDecimal;

public class ReportPaymentBean {
	private Long manualId;
	private String serviceType;
	private String receiptNoManual;
	private String accountSubNo;
	private String invoiceNo;
	private String customerName;
	private String department;
	private String serviceName;
	private String createBy;
	private String noRefer;
	private BigDecimal beforVat;
	private BigDecimal amount;
	private BigDecimal vatAmount;
	private String status;
	private String statusStr;
	
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getManualId() {
		return manualId;
	}
	public void setManualId(Long manualId) {
		this.manualId = manualId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getReceiptNoManual() {
		return receiptNoManual;
	}
	public void setReceiptNoManual(String receiptNoManual) {
		this.receiptNoManual = receiptNoManual;
	}
	public String getAccountSubNo() {
		return accountSubNo;
	}
	public void setAccountSubNo(String accountSubNo) {
		this.accountSubNo = accountSubNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getNoRefer() {
		return noRefer;
	}
	public void setNoRefer(String noRefer) {
		this.noRefer = noRefer;
	}
	public BigDecimal getBeforVat() {
		return beforVat;
	}
	public void setBeforVat(BigDecimal beforVat) {
		this.beforVat = beforVat;
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
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	
	
}
