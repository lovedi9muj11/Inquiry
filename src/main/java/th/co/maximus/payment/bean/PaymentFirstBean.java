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
	private String serviceNo;
	private Date startupDate;
	private Date endDate;
	private Date deadlines;
	private Date invoiceDate;
	private String custStatus;
	private int vatrate;
	private double balanceBeforeTax;
	private double vat;
	private double balanceOfTax;
	private double balanceSummary;
	private String remark;
	private double summaryTax;
	private List<PaymentTaxBean> paymentTax;
	private List<PaymentTranPriceBean> paymentTranPrice;
	
	
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
	public String getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}
	public Date getStartupDate() {
		return startupDate;
	}
	public void setStartupDate(Date startupDate) {
		this.startupDate = startupDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
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
	public int getVatrate() {
		return vatrate;
	}
	public void setVatrate(int vatrate) {
		this.vatrate = vatrate;
	}
	public double getBalanceBeforeTax() {
		return balanceBeforeTax;
	}
	public void setBalanceBeforeTax(double balanceBeforeTax) {
		this.balanceBeforeTax = balanceBeforeTax;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public double getBalanceOfTax() {
		return balanceOfTax;
	}
	public void setBalanceOfTax(double balanceOfTax) {
		this.balanceOfTax = balanceOfTax;
	}
	public double getBalanceSummary() {
		return balanceSummary;
	}
	public void setBalanceSummary(double balanceSummary) {
		this.balanceSummary = balanceSummary;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public double getSummaryTax() {
		return summaryTax;
	}
	public void setSummaryTax(double summaryTax) {
		this.summaryTax = summaryTax;
	}
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	
	
	
	
}
