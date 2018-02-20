package th.co.maximus.bean;

import java.math.BigDecimal;
import java.util.Date;

public class InvEpisOfflineReportBean {

	private String branArea;
	private String bracnCode;
	private String souce;
	private String custNo;
	private String custName;
	private String documentNo;
	private BigDecimal balanceSummary;
	private String invoiceNo;
	private Date documentDate;
	private String customerAddress;
	private String taxId;
	private String remark;
	private String paymentCode;
	private String vatRate;
	
	
	
	public InvEpisOfflineReportBean() {}
	
	public InvEpisOfflineReportBean(String branArea,String bracnCode,String souce,String custNo,String custName,String documentNo,BigDecimal balanceSummary,String invoiceNo,Date documentDate
			,String customerAddress,String taxId,String remark,String paymentCode,String vatRate) {
		this.branArea = branArea;
		this.bracnCode = bracnCode;
		this.souce = souce;
		this.custNo = custNo;
		this.custName = custName;
		this.documentNo = documentNo;
		this.balanceSummary = balanceSummary;
		this.invoiceNo = invoiceNo;
		this.documentDate = documentDate;
		this.customerAddress = customerAddress;
		this.taxId = taxId;
		this.remark = remark;
		this.paymentCode = paymentCode;
		this.vatRate = vatRate;
		
	}
	
	
	public String getBranArea() {
		return branArea;
	}
	public void setBranArea(String branArea) {
		this.branArea = branArea;
	}
	public String getBracnCode() {
		return bracnCode;
	}
	public void setBracnCode(String bracnCode) {
		this.bracnCode = bracnCode;
	}
	public String getSouce() {
		return souce;
	}
	public void setSouce(String souce) {
		this.souce = souce;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	public BigDecimal getBalanceSummary() {
		return balanceSummary;
	}
	public void setBalanceSummary(BigDecimal balanceSummary) {
		this.balanceSummary = balanceSummary;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Date getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getVatRate() {
		return vatRate;
	}

	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}
	
	
	
}
