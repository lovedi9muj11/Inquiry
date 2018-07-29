package th.co.maximus.bean;

import java.math.BigDecimal;
import java.util.Date;

public class InvEpisOfflineOtherBean {
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
	private BigDecimal discountSpecial;
	private String serviceName;
	private BigDecimal amount;
	private BigDecimal discountbeforvat;
	private Long methodId;
	private Long manualId;
	private String amountStr;
	private String beforeDiscount;
	private String runnumber;
	private String discountbeforvatStr;
	private String serviceNameStr;
	private String doctype;

	public InvEpisOfflineOtherBean() {
	}

	public InvEpisOfflineOtherBean(String branArea, String bracnCode, String serviceName, String custNo,
			String custName, String documentNo, BigDecimal balanceSummary, String invoiceNo, Date documentDate,
			String customerAddress, String taxId, String remark, String paymentCode, String vatRate,
			BigDecimal discountSpecial, BigDecimal amount, BigDecimal discountbeforvat, Long methodId, Long manualId,String doctype) {
		this.branArea = branArea;
		this.bracnCode = bracnCode;
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
		this.discountSpecial = discountSpecial;
		this.serviceName = serviceName;
		this.amount = amount;
		this.discountbeforvat = discountbeforvat;
		this.methodId = methodId;
		this.manualId = manualId;
		this.doctype = doctype;

	}

	public Long getManualId() {
		return manualId;
	}

	public void setManualId(Long manualId) {
		this.manualId = manualId;
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

	public BigDecimal getDiscountSpecial() {
		return discountSpecial;
	}

	public void setDiscountSpecial(BigDecimal discountSpecial) {
		this.discountSpecial = discountSpecial;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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

	public String getAmountStr() {
		return amountStr;
	}

	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}

	public String getBeforeDiscount() {
		return beforeDiscount;
	}

	public void setBeforeDiscount(String beforeDiscount) {
		this.beforeDiscount = beforeDiscount;
	}

	public String getRunnumber() {
		return runnumber;
	}

	public void setRunnumber(String runnumber) {
		this.runnumber = runnumber;
	}

	public String getDiscountbeforvatStr() {
		return discountbeforvatStr;
	}

	public void setDiscountbeforvatStr(String discountbeforvatStr) {
		this.discountbeforvatStr = discountbeforvatStr;
	}

	public String getServiceNameStr() {
		return serviceNameStr;
	}

	public void setServiceNameStr(String serviceNameStr) {
		this.serviceNameStr = serviceNameStr;
	}

	public Long getMethodId() {
		return methodId;
	}

	public void setMethodId(Long methodId) {
		this.methodId = methodId;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	

}
