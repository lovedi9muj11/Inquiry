package th.co.maximus.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ReportTaxRSBean {
	
	private Date documentDate;
	private String documentDateStr;
	private String invoice;
	private String custName;
	private String taxId;
	private String branCode;
	private String recordStatus;
	private String documentNo;
	private BigDecimal paidAmount;
	private String paidAmountStr;
	private BigDecimal amount;
	private int vatRate;
	private String vatRateStr;
	private BigDecimal beforeVat;
	private BigDecimal vat;
	private String beforeVatStr;
	private String vatStr;
	private String numberRun;
	private String createBy;
	
	private String beforVatSummery;
	private String vatSummery;
	private String afterVatSummery;
	
	private String from;
	private String to;
	private String quantity;
	private String quantitySummery;
	private String posNo;
	private String posName;
	
	private List<ReportTaxRSBean> reportTaxRSBeanList;
	
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public int getVatRate() {
		return vatRate;
	}
	public void setVatRate(int vatRate) {
		this.vatRate = vatRate;
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
	public String getNumberRun() {
		return numberRun;
	}
	public void setNumberRun(String numberRun) {
		this.numberRun = numberRun;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPosNo() {
		return posNo;
	}
	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public String getDocumentDateStr() {
		return documentDateStr;
	}
	public void setDocumentDateStr(String documentDateStr) {
		this.documentDateStr = documentDateStr;
	}
	public String getPaidAmountStr() {
		return paidAmountStr;
	}
	public void setPaidAmountStr(String paidAmountStr) {
		this.paidAmountStr = paidAmountStr;
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
	public String getQuantitySummery() {
		return quantitySummery;
	}
	public void setQuantitySummery(String quantitySummery) {
		this.quantitySummery = quantitySummery;
	}
	public String getVatRateStr() {
		return vatRateStr;
	}
	public void setVatRateStr(String vatRateStr) {
		this.vatRateStr = vatRateStr;
	}
	public List<ReportTaxRSBean> getReportTaxRSBeanList() {
		return reportTaxRSBeanList;
	}
	public void setReportTaxRSBeanList(List<ReportTaxRSBean> reportTaxRSBeanList) {
		this.reportTaxRSBeanList = reportTaxRSBeanList;
	}
	public String getBeforVatSummery() {
		return beforVatSummery;
	}
	public void setBeforVatSummery(String beforVatSummery) {
		this.beforVatSummery = beforVatSummery;
	}
	public String getVatSummery() {
		return vatSummery;
	}
	public void setVatSummery(String vatSummery) {
		this.vatSummery = vatSummery;
	}
	public String getAfterVatSummery() {
		return afterVatSummery;
	}
	public void setAfterVatSummery(String afterVatSummery) {
		this.afterVatSummery = afterVatSummery;
	}
	
}
