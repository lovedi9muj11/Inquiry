package th.co.maximus.payment.bean;

import java.io.Serializable;
import java.util.List;

public class PaymentOtherFirstBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String custName;
	private String custNo;
	private String taxId;
	private String documentNo;
	private String custAddress;
	private String custBrach;
	private String userGroup;
	private String userName;
	private String custStatus;
	private String vatrate;
	private double balanceBeforeTax;
	private double vat;
	private double balanceOfTax;
	private double balanceSummary;
	private double balanceBeforeTaxs;
	private double vats;
	private double balanceOfTaxs;
	private double balanceSummarys;
	private double balanceSum;
	private String remark;
	private double summaryTax;
	private double change;
//	private BigDecimal sale;
//	private BigDecimal salespacial;
	private List<PaymentBillBean> paymentBill;
	private List<PaymentTaxBean> paymentTax;
	private List<PaymentTranPriceBean> paymentTranPrice;
	private String docType;
	private String inputServiceDepartment;
	private String haveDocNo;
	private String incomeEdit;
	private String productCode;
	private String segmentCode;
	
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
//	public BigDecimal getSalespacial() {
//		return salespacial;
//	}
//	public void setSalespacial(BigDecimal salespacial) {
//		this.salespacial = salespacial;
//	}
//	public BigDecimal getSale() {
//		return sale;
//	}
//	public void setSale(BigDecimal sale) {
//		this.sale = sale;
//	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	
	public String getVatrate() {
		return vatrate;
	}
	public void setVatrate(String vatrate) {
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
	public List<PaymentBillBean> getPaymentBill() {
		return paymentBill;
	}
	public void setPaymentBill(List<PaymentBillBean> paymentBill) {
		this.paymentBill = paymentBill;
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
	public String getInputServiceDepartment() {
		return inputServiceDepartment;
	}
	public void setInputServiceDepartment(String inputServiceDepartment) {
		this.inputServiceDepartment = inputServiceDepartment;
	}
	public String getHaveDocNo() {
		return haveDocNo;
	}
	public void setHaveDocNo(String haveDocNo) {
		this.haveDocNo = haveDocNo;
	}
	public String getIncomeEdit() {
		return incomeEdit;
	}
	public void setIncomeEdit(String incomeEdit) {
		this.incomeEdit = incomeEdit;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getSegmentCode() {
		return segmentCode;
	}
	public void setSegmentCode(String segmentCode) {
		this.segmentCode = segmentCode;
	}
	
	
	
}
