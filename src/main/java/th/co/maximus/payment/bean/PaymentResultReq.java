package th.co.maximus.payment.bean;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentResultReq {

	private String custNo;
	private String custName;
	private String documentNo;
	private BigDecimal balanceSummary;
	private String invoiceNo;
	private Date invoiceDate;
	private Date dateLine;
	private BigDecimal beforeVat;
	private BigDecimal vat;
	private BigDecimal balanceOfvat;
	private BigDecimal deduction;
	private BigDecimal balancePrice;
	private String period;
	
	public PaymentResultReq() {
	}
	
	public PaymentResultReq(String custNo, String custName, String documentNo,BigDecimal balanceSummary,String invoiceNo,Date invoiceDate,Date dateLine,BigDecimal beforeVat,BigDecimal vat,
			BigDecimal balanceOfvat,BigDecimal deduction,BigDecimal balancePrice,String period) {
		
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
	
	
}
