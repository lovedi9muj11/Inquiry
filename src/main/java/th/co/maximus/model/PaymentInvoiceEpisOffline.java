package th.co.maximus.model;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentInvoiceEpisOffline {

	private String invoiceNo;
	private BigDecimal beforVat;
	private BigDecimal vatAmount;
	private BigDecimal amount;
	private String vatRate;
	private String customerName;
	private String customerAddress;
	private String customerSegment;
	private String customerBranch;
	private String taxNo;
	private String accountSubNo;
	private String period;
	private String serviceType;
	private String remark;
	private Integer quantity;
	private String incomeType;
	private BigDecimal discountBeforvat;
	private BigDecimal discountSpecial;
	private String amountType;
	private String department;
	private String serviceName;
	private String serviceCode;
	private Date invoiceDate;
	
	private BigDecimal discount;
	private BigDecimal discountVat;
	
	public PaymentInvoiceEpisOffline(){}
	public PaymentInvoiceEpisOffline(String invoiceNo,BigDecimal beforVat,BigDecimal vatAmount,BigDecimal amount,String vatRate,String customerName,
			String customerAddress,String customerSegment,String customerBranch,String taxNo,String accountSubNo,
			String period,String serviceType,String remark,Integer quantity,String incomeType,BigDecimal discountBeforvat,BigDecimal discountSpecial,
			String amountType,String department,String serviceName,String serviceCode,Date invoiceDate){
		this.invoiceNo = invoiceNo;
		this.beforVat = beforVat;
		this.vatAmount = vatAmount;
		this.amount = amount;
		this.vatRate = vatRate;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerSegment = customerSegment;
		this.customerBranch = customerBranch;
		this.taxNo = taxNo;
		this.accountSubNo = accountSubNo;
		this.period = period;
		this.serviceType = serviceType;
		this.remark = remark;
		this.quantity = quantity;
		this.incomeType = incomeType;
		this.discountBeforvat = discountBeforvat;
		this.discountSpecial = discountSpecial;
		this.amountType = amountType;
		this.department = department;
		this.serviceName = serviceName;
		this.serviceCode = serviceCode;
		this.invoiceDate = invoiceDate;
		
	}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public BigDecimal getDiscountBeforvat() {
		return discountBeforvat;
	}
	public void setDiscountBeforvat(BigDecimal discountBeforvat) {
		this.discountBeforvat = discountBeforvat;
	}
	public BigDecimal getDiscountSpecial() {
		return discountSpecial;
	}
	public void setDiscountSpecial(BigDecimal discountSpecial) {
		this.discountSpecial = discountSpecial;
	}
	public String getAmountType() {
		return amountType;
	}
	public void setAmountType(String amountType) {
		this.amountType = amountType;
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
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public BigDecimal getDiscountVat() {
		return discountVat;
	}
	public void setDiscountVat(BigDecimal discountVat) {
		this.discountVat = discountVat;
	}

	

	
	
	
}
