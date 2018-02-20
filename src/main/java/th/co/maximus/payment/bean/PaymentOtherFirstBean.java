package th.co.maximus.payment.bean;

import java.io.Serializable;
import java.util.List;

public class PaymentOtherFirstBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String inputCustomerBillNo;
	private String inputCustomerName;
	private String inputCustomerTaxNo;
	private String inputCustomerBranch;
	private String userGroup;
	private String inputCustomerAddress;
	private double preItemsDiscount;
	private double itemsDiscount;
	private double discount;
	private double balanceBeforeTax;
	private double balanceOfTax;
	private double balanceSummary;
	private double vats;
	private String inputAdditionalRemark;
	private double summaryTax;
	private String vatRadio;
	private List<PaymentBillBean> paymentBill;
	private List<PaymentTaxBean> paymentTax;
	private List<PaymentTranPriceBean> paymentTranPrice;
	
	
	
	public String getVatRadio() {
		return vatRadio;
	}
	public void setVatRadio(String vatRadio) {
		this.vatRadio = vatRadio;
	}
	public String getInputCustomerBillNo() {
		return inputCustomerBillNo;
	}
	public void setInputCustomerBillNo(String inputCustomerBillNo) {
		this.inputCustomerBillNo = inputCustomerBillNo;
	}
	public String getInputCustomerName() {
		return inputCustomerName;
	}
	public void setInputCustomerName(String inputCustomerName) {
		this.inputCustomerName = inputCustomerName;
	}
	public String getInputCustomerTaxNo() {
		return inputCustomerTaxNo;
	}
	public void setInputCustomerTaxNo(String inputCustomerTaxNo) {
		this.inputCustomerTaxNo = inputCustomerTaxNo;
	}
	public String getInputCustomerBranch() {
		return inputCustomerBranch;
	}
	public void setInputCustomerBranch(String inputCustomerBranch) {
		this.inputCustomerBranch = inputCustomerBranch;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public String getInputCustomerAddress() {
		return inputCustomerAddress;
	}
	public void setInputCustomerAddress(String inputCustomerAddress) {
		this.inputCustomerAddress = inputCustomerAddress;
	}
	public double getPreItemsDiscount() {
		return preItemsDiscount;
	}
	public void setPreItemsDiscount(double preItemsDiscount) {
		this.preItemsDiscount = preItemsDiscount;
	}
	public double getItemsDiscount() {
		return itemsDiscount;
	}
	public void setItemsDiscount(double itemsDiscount) {
		this.itemsDiscount = itemsDiscount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getBalanceBeforeTax() {
		return balanceBeforeTax;
	}
	public void setBalanceBeforeTax(double balanceBeforeTax) {
		this.balanceBeforeTax = balanceBeforeTax;
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
	public double getVats() {
		return vats;
	}
	public void setVats(double vats) {
		this.vats = vats;
	}
	public String getInputAdditionalRemark() {
		return inputAdditionalRemark;
	}
	public void setInputAdditionalRemark(String inputAdditionalRemark) {
		this.inputAdditionalRemark = inputAdditionalRemark;
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
	
	
	
	
}
