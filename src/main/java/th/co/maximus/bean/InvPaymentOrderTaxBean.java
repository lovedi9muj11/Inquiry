package th.co.maximus.bean;

import java.math.BigDecimal;
import java.util.Date;

public class InvPaymentOrderTaxBean {
	// Head Report
	private String headName;
	private String dateForm;
	private String dateTo;
	private String printDate;
	private String branchArea;
	private String invoiceNo;
	private String branchCodeEmp;
	private String reportStatus;
	
	// Detail Report
	private int autoNumber;
	private Date documentDate;
	private String documentNo;
	private String custName;
	private String empName;
	private String taxId;
	private String branchCode;
	private BigDecimal beforeVat;
	private BigDecimal vat;
	private BigDecimal summary;
	private String payType;
	
	// summary Report
	private String empSummaryName;
	private int vatRate;
	
	private BigDecimal beforeVatRq;
	private String beforeVatRqStr;
	private BigDecimal vatRq;
	private String vatRqStr;
	private BigDecimal summaryRq;
	private String summaryRqStr;
	
	private BigDecimal beforeVatSummary;
	private String beforeVatSummaryStr;
	private BigDecimal vatSummary;
	private String vatSummaryStr;
	private BigDecimal summarySummary;
	private String summarySummaryStr;
	
	private String beforeVatReport;
	private String vatReport;
	private String summaryReport;
	private String documentDateReport;
	private String autoNumberReport;
	
	private BigDecimal beforeVatZero;
	private String beforeVatZeroStr;
	private BigDecimal vatZero;
	private String vatZeroStr;
	private BigDecimal summaryZero;
	private String summaryZeroStr;
	
	
	public InvPaymentOrderTaxBean(){}
	
	public InvPaymentOrderTaxBean(Date documentDate,String documentNo,String custName,String empName,String taxId,String invoiceNo,
			String branchArea,String branchCode,BigDecimal summary,String payType,int vatRate) {
		this.documentDate = documentDate;
		this.documentNo = documentNo;
		this.custName = custName;
		this.empName = empName;
		this.taxId = taxId;
		this.invoiceNo = invoiceNo;
		this.branchArea = branchArea;
		this.branchCode = branchCode;
		this.summary = summary;
		this.payType = payType;
		this.vatRate = vatRate;
		
	}
	
	
	
	
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public String getDateForm() {
		return dateForm;
	}
	public void setDateForm(String dateForm) {
		this.dateForm = dateForm;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getPrintDate() {
		return printDate;
	}
	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}
	public String getBranchArea() {
		return branchArea;
	}
	public void setBranchArea(String branchArea) {
		this.branchArea = branchArea;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getBranchCodeEmp() {
		return branchCodeEmp;
	}
	public void setBranchCodeEmp(String branchCodeEmp) {
		this.branchCodeEmp = branchCodeEmp;
	}
	public int getAutoNumber() {
		return autoNumber;
	}
	public void setAutoNumber(int autoNumber) {
		this.autoNumber = autoNumber;
	}
	public Date getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTaxId() {
		return taxId;
	}
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
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
	public BigDecimal getSummary() {
		return summary;
	}
	public void setSummary(BigDecimal summary) {
		this.summary = summary;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getEmpSummaryName() {
		return empSummaryName;
	}
	public void setEmpSummaryName(String empSummaryName) {
		this.empSummaryName = empSummaryName;
	}
	public int getVatRate() {
		return vatRate;
	}
	public void setVatRate(int vatRate) {
		this.vatRate = vatRate;
	}
	public BigDecimal getBeforeVatRq() {
		return beforeVatRq;
	}
	public void setBeforeVatRq(BigDecimal beforeVatRq) {
		this.beforeVatRq = beforeVatRq;
	}
	public BigDecimal getVatRq() {
		return vatRq;
	}
	public void setVatRq(BigDecimal vatRq) {
		this.vatRq = vatRq;
	}
	public BigDecimal getSummaryRq() {
		return summaryRq;
	}
	public void setSummaryRq(BigDecimal summaryRq) {
		this.summaryRq = summaryRq;
	}
	public BigDecimal getBeforeVatSummary() {
		return beforeVatSummary;
	}
	public void setBeforeVatSummary(BigDecimal beforeVatSummary) {
		this.beforeVatSummary = beforeVatSummary;
	}
	public BigDecimal getVatSummary() {
		return vatSummary;
	}
	public void setVatSummary(BigDecimal vatSummary) {
		this.vatSummary = vatSummary;
	}
	public BigDecimal getSummarySummary() {
		return summarySummary;
	}
	public void setSummarySummary(BigDecimal summarySummary) {
		this.summarySummary = summarySummary;
	}

	public String getBeforeVatReport() {
		return beforeVatReport;
	}

	public void setBeforeVatReport(String beforeVatReport) {
		this.beforeVatReport = beforeVatReport;
	}

	public String getVatReport() {
		return vatReport;
	}

	public void setVatReport(String vatReport) {
		this.vatReport = vatReport;
	}

	public String getSummaryReport() {
		return summaryReport;
	}

	public void setSummaryReport(String summaryReport) {
		this.summaryReport = summaryReport;
	}

	public String getDocumentDateReport() {
		return documentDateReport;
	}

	public void setDocumentDateReport(String documentDateReport) {
		this.documentDateReport = documentDateReport;
	}

	public String getAutoNumberReport() {
		return autoNumberReport;
	}

	public void setAutoNumberReport(String autoNumberReport) {
		this.autoNumberReport = autoNumberReport;
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

	public BigDecimal getBeforeVatZero() {
		return beforeVatZero;
	}

	public void setBeforeVatZero(BigDecimal beforeVatZero) {
		this.beforeVatZero = beforeVatZero;
	}

	public BigDecimal getVatZero() {
		return vatZero;
	}

	public void setVatZero(BigDecimal vatZero) {
		this.vatZero = vatZero;
	}

	public BigDecimal getSummaryZero() {
		return summaryZero;
	}

	public void setSummaryZero(BigDecimal summaryZero) {
		this.summaryZero = summaryZero;
	}

	public String getBeforeVatSummaryStr() {
		return beforeVatSummaryStr;
	}

	public void setBeforeVatSummaryStr(String beforeVatSummaryStr) {
		this.beforeVatSummaryStr = beforeVatSummaryStr;
	}

	public String getVatSummaryStr() {
		return vatSummaryStr;
	}

	public void setVatSummaryStr(String vatSummaryStr) {
		this.vatSummaryStr = vatSummaryStr;
	}

	public String getSummarySummaryStr() {
		return summarySummaryStr;
	}

	public void setSummarySummaryStr(String summarySummaryStr) {
		this.summarySummaryStr = summarySummaryStr;
	}

	public String getBeforeVatZeroStr() {
		return beforeVatZeroStr;
	}

	public void setBeforeVatZeroStr(String beforeVatZeroStr) {
		this.beforeVatZeroStr = beforeVatZeroStr;
	}

	public String getVatZeroStr() {
		return vatZeroStr;
	}

	public void setVatZeroStr(String vatZeroStr) {
		this.vatZeroStr = vatZeroStr;
	}

	public String getSummaryZeroStr() {
		return summaryZeroStr;
	}

	public void setSummaryZeroStr(String summaryZeroStr) {
		this.summaryZeroStr = summaryZeroStr;
	}

	public String getBeforeVatRqStr() {
		return beforeVatRqStr;
	}

	public void setBeforeVatRqStr(String beforeVatRqStr) {
		this.beforeVatRqStr = beforeVatRqStr;
	}

	public String getVatRqStr() {
		return vatRqStr;
	}

	public void setVatRqStr(String vatRqStr) {
		this.vatRqStr = vatRqStr;
	}

	public String getSummaryRqStr() {
		return summaryRqStr;
	}

	public void setSummaryRqStr(String summaryRqStr) {
		this.summaryRqStr = summaryRqStr;
	}
	
	
			
	

}
