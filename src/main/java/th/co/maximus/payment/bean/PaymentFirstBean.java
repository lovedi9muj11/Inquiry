package th.co.maximus.payment.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import th.co.maximus.core.utils.converter.CustomDateDeserializer;
import th.co.maximus.core.utils.converter.CustomDateSerializer;

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
	private int vatrate;
	private double balanceBeforeTax;
	private double vat;
	private double balanceOfTax;
	private double balanceSummary;
	private double balanceBeforeTaxs;
	private double vats;
	private double balanceOfTaxs;
	private double balanceSummarys;
	private double balanceSum;
	private double chang;
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
	public double getBalanceBeforeTaxs() {
		return balanceBeforeTaxs;
	}
	public void setBalanceBeforeTaxs(double balanceBeforeTaxs) {
		this.balanceBeforeTaxs = balanceBeforeTaxs;
	}
	public double getVats() {
		return vats;
	}
	public void setVats(double vats) {
		this.vats = vats;
	}
	public double getBalanceOfTaxs() {
		return balanceOfTaxs;
	}
	public void setBalanceOfTaxs(double balanceOfTaxs) {
		this.balanceOfTaxs = balanceOfTaxs;
	}
	public double getBalanceSummarys() {
		return balanceSummarys;
	}
	public void setBalanceSummarys(double balanceSummarys) {
		this.balanceSummarys = balanceSummarys;
	}
	public double getBalanceSum() {
		return balanceSum;
	}
	public void setBalanceSum(double balanceSum) {
		this.balanceSum = balanceSum;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getChang() {
		return chang;
	}
	public void setChang(double chang) {
		this.chang = chang;
	}
	
	
	
	
}
