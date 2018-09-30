package th.co.maximus.payment.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PaymentFirstBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String custName;
	private String custNo;
	private String taxId;
	private String documentNo;
	private String custAddress;
	private String custBrach;
	private String userGroup;
	private String debtCollection;
	private String invoiceNo;
	private String userName;
	private String serviceNo;
	private String startupDate;
	private String endDate;
	private Date deadlines;
	private Date invoiceDate;
	private String custStatus;
	private Double taxOnly;
	private String vatrate;
	private Double balanceBeforeTax;
	private Double vat;
	private Double balanceOfTax;
	private Double balanceSummary;
	private Double balanceBeforeTaxs;
	private Double vats;
	private Double balanceOfTaxs;
	private Double balanceSummarys;
	private Double balanceSum;
	private Double amountInvoice;
	private Double chang;
	private String remark;
	private Double summaryTax;
	private List<PaymentTaxBean> paymentTax;
	private List<PaymentTranPriceBean> paymentTranPrice;
	private String nonVat;
	private String docType;
	private String isDiscountFlg;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustBrach() {
		return custBrach;
	}
	public void setCustBrach(String custBrach) {
		this.custBrach = custBrach;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public String getDebtCollection() {
		return debtCollection;
	}
	public void setDebtCollection(String debtCollection) {
		this.debtCollection = debtCollection;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}
	public String getStartupDate() {
		return startupDate;
	}
	public void setStartupDate(String startupDate) {
		this.startupDate = startupDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Date getDeadlines() {
		return deadlines;
	}
	public void setDeadlines(Date deadlines) {
		this.deadlines = deadlines;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	public Double getTaxOnly() {
		return taxOnly;
	}
	public void setTaxOnly(Double taxOnly) {
		this.taxOnly = taxOnly;
	}
	public String getVatrate() {
		return vatrate;
	}
	public void setVatrate(String vatrate) {
		this.vatrate = vatrate;
	}
	public Double getBalanceBeforeTax() {
		return balanceBeforeTax;
	}
	public void setBalanceBeforeTax(Double balanceBeforeTax) {
		this.balanceBeforeTax = balanceBeforeTax;
	}
	public Double getVat() {
		return vat;
	}
	public void setVat(Double vat) {
		this.vat = vat;
	}
	public Double getBalanceOfTax() {
		return balanceOfTax;
	}
	public void setBalanceOfTax(Double balanceOfTax) {
		this.balanceOfTax = balanceOfTax;
	}
	public Double getBalanceSummary() {
		return balanceSummary;
	}
	public void setBalanceSummary(Double balanceSummary) {
		this.balanceSummary = balanceSummary;
	}
	public Double getBalanceBeforeTaxs() {
		return balanceBeforeTaxs;
	}
	public void setBalanceBeforeTaxs(Double balanceBeforeTaxs) {
		this.balanceBeforeTaxs = balanceBeforeTaxs;
	}
	public Double getVats() {
		return vats;
	}
	public void setVats(Double vats) {
		this.vats = vats;
	}
	public Double getBalanceOfTaxs() {
		return balanceOfTaxs;
	}
	public void setBalanceOfTaxs(Double balanceOfTaxs) {
		this.balanceOfTaxs = balanceOfTaxs;
	}
	public Double getBalanceSummarys() {
		return balanceSummarys;
	}
	public void setBalanceSummarys(Double balanceSummarys) {
		this.balanceSummarys = balanceSummarys;
	}
	public Double getBalanceSum() {
		return balanceSum;
	}
	public void setBalanceSum(Double balanceSum) {
		this.balanceSum = balanceSum;
	}
	public Double getAmountInvoice() {
		return amountInvoice;
	}
	public void setAmountInvoice(Double amountInvoice) {
		this.amountInvoice = amountInvoice;
	}
	public Double getChang() {
		return chang;
	}
	public void setChang(Double chang) {
		this.chang = chang;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Double getSummaryTax() {
		return summaryTax;
	}
	public void setSummaryTax(Double summaryTax) {
		this.summaryTax = summaryTax;
	}
	public List<PaymentTaxBean> getPaymentTax() {
		return paymentTax;
	}
	public void setPaymentTax(List<PaymentTaxBean> paymentTax) {
		this.paymentTax = paymentTax;
	}
	public List<PaymentTranPriceBean> getPaymentTranPrice() {
		return paymentTranPrice;
	}
	public void setPaymentTranPrice(List<PaymentTranPriceBean> paymentTranPrice) {
		this.paymentTranPrice = paymentTranPrice;
	}
	public String getNonVat() {
		return nonVat;
	}
	public void setNonVat(String nonVat) {
		this.nonVat = nonVat;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getIsDiscountFlg() {
		return isDiscountFlg;
	}
	public void setIsDiscountFlg(String isDiscountFlg) {
		this.isDiscountFlg = isDiscountFlg;
	}
	
	
	
	
	
}
