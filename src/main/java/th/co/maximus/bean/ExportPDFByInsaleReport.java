package th.co.maximus.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ExportPDFByInsaleReport {
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
	private BigDecimal beforeVat;
	private BigDecimal vat;
	private String dateDocument;
	private BigDecimal discountSpecial;
	private BigDecimal balanceBefore;
	private String serviceName;
	private BigDecimal amount;
	private BigDecimal discountbeforvat;
	
	
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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
	public BigDecimal getBeforeVat() {
		return beforeVat;
	}
	public void setBeforeVat(BigDecimal beforeVat) {
		this.beforeVat = beforeVat;
	}
	public BigDecimal getVat() {
		return vat;
	}
	public void setVat(BigDecimal vat) {
		this.vat = vat;
	}
	public String getDateDocument() {
		return dateDocument;
	}
	public void setDateDocument(String dateDocument) {
		this.dateDocument = dateDocument;
	}
	public BigDecimal getDiscountSpecial() {
		return discountSpecial;
	}
	public void setDiscountSpecial(BigDecimal discountSpecial) {
		this.discountSpecial = discountSpecial;
	}
	public BigDecimal getBalanceBefore() {
		return balanceBefore;
	}
	public void setBalanceBefore(BigDecimal balanceBefore) {
		this.balanceBefore = balanceBefore;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getDiscountbeforvat() {
		return discountbeforvat;
	}
	public void setDiscountbeforvat(BigDecimal discountbeforvat) {
		this.discountbeforvat = discountbeforvat;
	}
	
	
}
