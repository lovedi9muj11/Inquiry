package th.co.maximus.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TmpInvoiceBean {
	private int invId;
	private int manualId;
	private String invoiceNo;
	private Date invoiceDate;
	private Date dateLine;
	private BigDecimal beforVat;
	private BigDecimal amount;
	private BigDecimal vatAmount;
	private BigDecimal paidAmount;
	private String vatRate;
	private String customerName;
	private String customerAddress;
	private String customerSegment;
	private String customerBranch;
	private String taxno;
	private String accountSubNo;
	private String period;
	private BigDecimal change;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	private String recordStatus;
	private Double discount;
	public int getInvId() {
		return invId;
	}
	public void setInvId(int invId) {
		this.invId = invId;
	}
	public int getManualId() {
		return manualId;
	}
	public void setManualId(int manualId) {
		this.manualId = manualId;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public Date getDateLine() {
		return dateLine;
	}
	public void setDateLine(Date dateLine) {
		this.dateLine = dateLine;
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
	public String getTaxno() {
		return taxno;
	}
	public void setTaxno(String taxno) {
		this.taxno = taxno;
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


	public BigDecimal getChange() {
		return change;
	}
	public void setChange(BigDecimal change) {
		this.change = change;
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
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	
	
	

}
