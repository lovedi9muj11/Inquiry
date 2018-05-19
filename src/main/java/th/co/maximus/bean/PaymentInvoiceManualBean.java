package th.co.maximus.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PaymentInvoiceManualBean {

	private Long paymentInvoiceManualId;
	private Long manualId;
	private String source;
	private String invoiceNo;
	private double beforVat;
	private double amount;
	private double vatAmount;
	private int vatRate;
	private String customerName;
	private String customerAddress;
	private String customerSegment;
	private String customerBranch;
	private String taxNo;
	private String subNo;
	private String period;
	private String serviceType;
	private String clearing;
	private String printReceipt;
	private String remark;
	private String createBy;
	private Timestamp createDate;
	private String updateBy;
	private Timestamp updateDate;
	private String recordStatus;
	private Date invoiceDate;

	private String department;
	private String serviceCode;
	private Integer quantity;
	private String incometype;
	private BigDecimal discountbeforvat;
	private BigDecimal discountspecial;
	private String amounttype;
	private String accountSubNo;
	private String serviceName;

	public Long getPaymentInvoiceManualId() {
		return paymentInvoiceManualId;
	}

	public void setPaymentInvoiceManualId(Long paymentInvoiceManualId) {
		this.paymentInvoiceManualId = paymentInvoiceManualId;
	}

	public Long getManualId() {
		return manualId;
	}

	public void setManualId(Long manualId) {
		this.manualId = manualId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public double getBeforVat() {
		return beforVat;
	}

	public void setBeforVat(double beforVat) {
		this.beforVat = beforVat;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public int getVatRate() {
		return vatRate;
	}

	public void setVatRate(int vatRate) {
		this.vatRate = vatRate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerSegment() {
		return customerSegment;
	}

	public void setCustomerSegment(String customerSegment) {
		this.customerSegment = customerSegment;
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

	public String getSubNo() {
		return subNo;
	}

	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getClearing() {
		return clearing;
	}

	public void setClearing(String clearing) {
		this.clearing = clearing;
	}

	public String getPrintReceipt() {
		return printReceipt;
	}

	public void setPrintReceipt(String printReceipt) {
		this.printReceipt = printReceipt;
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

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getIncometype() {
		return incometype;
	}

	public void setIncometype(String incometype) {
		this.incometype = incometype;
	}

	public BigDecimal getDiscountbeforvat() {
		return discountbeforvat;
	}

	public void setDiscountbeforvat(BigDecimal discountbeforvat) {
		this.discountbeforvat = discountbeforvat;
	}

	public BigDecimal getDiscountspecial() {
		return discountspecial;
	}

	public void setDiscountspecial(BigDecimal discountspecial) {
		this.discountspecial = discountspecial;
	}

	public String getAmounttype() {
		return amounttype;
	}

	public void setAmounttype(String amounttype) {
		this.amounttype = amounttype;
	}

	public String getAccountSubNo() {
		return accountSubNo;
	}

	public void setAccountSubNo(String accountSubNo) {
		this.accountSubNo = accountSubNo;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

}
