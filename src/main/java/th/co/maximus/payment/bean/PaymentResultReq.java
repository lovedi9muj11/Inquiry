package th.co.maximus.payment.bean;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentResultReq {
	private int manualId;
	private String custNo;
	private String custName;
	private String documentNo;
	private BigDecimal balanceSummary;
	private String invoiceNo;
	private Date invoiceDate;
	private Date dateLine;
	private String invoiceDateRS;
	private String dateLineRS;
	private BigDecimal beforeVat;
	private BigDecimal vat;
	private BigDecimal balanceOfvat;
	private BigDecimal deduction;
	private BigDecimal balancePrice;
	private BigDecimal balanceAmount;
	private String period;
	private BigDecimal discount;
//	private String discountStr;
	private String quantity;
	private BigDecimal paid_amount;
	private BigDecimal discountspacal;
	private BigDecimal amount;
	
	private String amountStr;
	private String balanceSummaryStr;
	private String beforeVatStr;
	private String vatStr;
	private String balanceOfvatStr;
	private String deductionStr;
	private String balancePriceStr;
	private String discountStr;
	private String serviceName;
	private String serviceCode;
	private String paid_amountStr;
	private String discountspacalStr;
	
	public PaymentResultReq() {
	}
	
	public PaymentResultReq(String custNo, String custName, String documentNo,BigDecimal balanceSummary,String invoiceNo,Date invoiceDate,Date dateLine,BigDecimal beforeVat,BigDecimal vat,
			BigDecimal balanceOfvat,BigDecimal deduction,BigDecimal balancePrice,String period,BigDecimal balanceAmount,BigDecimal discount) {
		
		this.custNo = custNo;
		this.custName = custName;
		this.documentNo = documentNo;
		this.balanceSummary = balanceSummary;
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.dateLine = dateLine;
		this.beforeVat = beforeVat;
		this.vat = vat;
		this.balanceOfvat = balanceOfvat;
		this.deduction = deduction;
		this.balancePrice = balancePrice;
		this.period = period;
		this.balanceAmount = balanceAmount;
		this.discount = discount;
		

	}
	
	
//	public PaymentResultReq(String custNo, String custName, String documentNo,BigDecimal balanceSummary,String invoiceNo,Date invoiceDate,Date dateLine,BigDecimal beforeVat,BigDecimal vat,
//			BigDecimal balanceOfvat,BigDecimal deduction,BigDecimal balancePrice ,BigDecimal paid_amount,BigDecimal discount ,String  serviceName, String serviceCode ,String quantity ) {
//		
//		this.custNo = custNo;
//		this.custName = custName;
//		this.documentNo = documentNo;
//		this.balanceSummary = balanceSummary;
//		this.invoiceNo = invoiceNo;
//		this.invoiceDate = invoiceDate;
//		this.dateLine = dateLine;
//		this.beforeVat = beforeVat;
//		this.vat = vat;
//		this.balanceOfvat = balanceOfvat;
//		this.deduction = deduction;
//		this.balancePrice = balancePrice;
//		this.paid_amount = paid_amount;
//		this.discount = discount;
//		this.serviceCode = serviceCode;
//		this.serviceName = serviceName;
//		this.quantity = quantity;
//		
//		
//
//	}

	public int getManualId() {
		return manualId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAmountStr() {
		return amountStr;
	}

	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}

	public void setManualId(int manualId) {
		this.manualId = manualId;
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

	public BigDecimal getBalanceOfvat() {
		return balanceOfvat;
	}

	public void setBalanceOfvat(BigDecimal balanceOfvat) {
		this.balanceOfvat = balanceOfvat;
	}

	public BigDecimal getDeduction() {
		return deduction;
	}

	public void setDeduction(BigDecimal deduction) {
		this.deduction = deduction;
	}

	public BigDecimal getBalancePrice() {
		return balancePrice;
	}

	public void setBalancePrice(BigDecimal balancePrice) {
		this.balancePrice = balancePrice;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getInvoiceDateRS() {
		return invoiceDateRS;
	}

	public void setInvoiceDateRS(String invoiceDateRS) {
		this.invoiceDateRS = invoiceDateRS;
	}

	public String getDateLineRS() {
		return dateLineRS;
	}

	public void setDateLineRS(String dateLineRS) {
		this.dateLineRS = dateLineRS;
	}

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getBalanceSummaryStr() {
		return balanceSummaryStr;
	}

	public void setBalanceSummaryStr(String balanceSummaryStr) {
		this.balanceSummaryStr = balanceSummaryStr;
	}

	public String getBeforeVatStr() {
		return beforeVatStr;
	}

	public void setBeforeVatStr(String beforeVatStr) {
		this.beforeVatStr = beforeVatStr;
	}

	public String getVatStr() {
		return vatStr;
	}

	public void setVatStr(String vatStr) {
		this.vatStr = vatStr;
	}

	public String getBalanceOfvatStr() {
		return balanceOfvatStr;
	}

	public void setBalanceOfvatStr(String balanceOfvatStr) {
		this.balanceOfvatStr = balanceOfvatStr;
	}

	public String getDeductionStr() {
		return deductionStr;
	}

	public void setDeductionStr(String deductionStr) {
		this.deductionStr = deductionStr;
	}

	public String getBalancePriceStr() {
		return balancePriceStr;
	}

	public void setBalancePriceStr(String balancePriceStr) {
		this.balancePriceStr = balancePriceStr;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getDiscountStr() {
		return discountStr;
	}

	public void setDiscountStr(String discountStr) {
		this.discountStr = discountStr;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	

	public String getPaid_amountStr() {
		return paid_amountStr;
	}

	public void setPaid_amountStr(String paid_amountStr) {
		this.paid_amountStr = paid_amountStr;
	}

	public BigDecimal getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(BigDecimal paid_amount) {
		this.paid_amount = paid_amount;
	}

	public BigDecimal getDiscountspacal() {
		return discountspacal;
	}

	public void setDiscountspacal(BigDecimal discountspacal) {
		this.discountspacal = discountspacal;
	}

	public String getDiscountspacalStr() {
		return discountspacalStr;
	}

	public void setDiscountspacalStr(String discountspacalStr) {
		this.discountspacalStr = discountspacalStr;
	}

	

	

	
	
}
