package th.co.maximus.bean;

import java.math.BigDecimal;
import java.util.Date;

public class HistoryPaymentRS {

	private Date documentDate;
	private String invoice;
	private String custName;
	private String taxId;
	private String branCode;
	private String recordStatus;
	private String documentNo;
	private BigDecimal paidAmount;
	private int vatRate;
	private BigDecimal beforeVat;
	private BigDecimal vat;
	private String numberRun;
	
	
	public HistoryPaymentRS(){}
	
	public HistoryPaymentRS(Date documentDate,String invoice,String custName,String taxId,String branCode,String recordStatus,String documentNo,BigDecimal paidAmount,int vatRate,BigDecimal vat,BigDecimal beforeVat){
		this.documentDate = documentDate;
		this.invoice = invoice;
		this.custName = custName;
		this.taxId = taxId;
		this.branCode = branCode;
		this.recordStatus = recordStatus;
		this.documentNo = documentNo;
		this.paidAmount = paidAmount;
		this.vatRate = vatRate;
		this.vat = vat;
		this.beforeVat = beforeVat;
		
	}
	
	
	public Date getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public String getBranCode() {
		return branCode;
	}
	public void setBranCode(String branCode) {
		this.branCode = branCode;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
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

	public int getVatRate() {
		return vatRate;
	}

	public void setVatRate(int vatRate) {
		this.vatRate = vatRate;
	}

	public String getNumberRun() {
		return numberRun;
	}

	public void setNumberRun(String numberRun) {
		this.numberRun = numberRun;
	}
	
	
	
}
