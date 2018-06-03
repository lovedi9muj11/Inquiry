package th.co.maximus.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class InvoiceBean {
	private Long invoiceId;
	private Long manualId;
	private String invoiceNo;
	private Timestamp invoiceDate;
	private Timestamp dateLine;
	private BigDecimal beforVat;
	private BigDecimal vatAmount;
	private BigDecimal paidAmount;
	private BigDecimal amount;
	private String vatRate;
	private String customerName;
	private String custometAddress;
	private String custometSegment;
	private String customerBranch;
	private String taxNo;
	private String accountSubNo;
	private String period;
	private String serviceName;
	private String serviceType;
	private BigDecimal chang;
	private String createBy;
	private Timestamp createDate;
	private String updateBy;
	private Timestamp updateDate;
	private String recordStatus;
	private BigDecimal discount;
	private String value;
	String invoiceDateRs;
	
	
	public String getInvoiceDateRs() {
		return invoiceDateRs;
	}

	public void setInvoiceDateRs(String invoiceDateRs) {
		this.invoiceDateRs = invoiceDateRs;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getManualId() {
		return manualId;
	}

	public void setManualId(Long manualId) {
		this.manualId = manualId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Timestamp getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Timestamp invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Timestamp getDateLine() {
		return dateLine;
	}

	public void setDateLine(Timestamp dateLine) {
		this.dateLine = dateLine;
	}

	public BigDecimal getBeforVat() {
		return beforVat;
	}

	public void setBeforVat(BigDecimal beforVat) {
		this.beforVat = beforVat;
	}

	public BigDecimal getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getVatRate() {
		return vatRate;
	}

	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustometAddress() {
		return custometAddress;
	}

	public void setCustometAddress(String custometAddress) {
		this.custometAddress = custometAddress;
	}

	public String getCustometSegment() {
		return custometSegment;
	}

	public void setCustometSegment(String custometSegment) {
		this.custometSegment = custometSegment;
	}

	public String getCustomerBranch() {
		return customerBranch;
	}

	public void setCustomerBranch(String customerBranch) {
		this.customerBranch = customerBranch;
	}

	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public String getAccountSubNo() {
		return accountSubNo;
	}

	public void setAccountSubNo(String accountSubNo) {
		this.accountSubNo = accountSubNo;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public BigDecimal getChang() {
		return chang;
	}

	public void setChang(BigDecimal chang) {
		this.chang = chang;
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

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
