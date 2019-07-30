package th.co.maximus.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PaymentEpisOfflineDTO {
	private String invoiceNo;
	private String receiptNo;
	private Date paidDate;
	private String branchArea;
	private String branchCode;
	private BigDecimal paidAmount;
	private String source;
	private String remark;
	private String accountNo;
	private String manualID;
	private BigDecimal vatAmount;
	private BigDecimal vatRate;
	private String creatBy;
	private String posNo;
	private List<PaymentInvoiceEpisOffline> paymentInvoice;
	private List<DuductionEpisOffline> duduction;
	private List<TrsMethodEpisOffline> trsMethod;
	private String chanel;
	
	
	public String getChanel() {
		return chanel;
	}

	public void setChanel(String chanel) {
		this.chanel = chanel;
	}

	public String getPosNo() {
		return posNo;
	}

	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public BigDecimal getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public PaymentEpisOfflineDTO(){}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public String getBranchArea() {
		return branchArea;
	}
	public void setBranchArea(String branchArea) {
		this.branchArea = branchArea;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public List<PaymentInvoiceEpisOffline> getPaymentInvoice() {
		return paymentInvoice;
	}
	public void setPaymentInvoice(List<PaymentInvoiceEpisOffline> paymentInvoice) {
		this.paymentInvoice = paymentInvoice;
	}
	public List<DuductionEpisOffline> getDuduction() {
		return duduction;
	}
	public void setDuduction(List<DuductionEpisOffline> duduction) {
		this.duduction = duduction;
	}
	public List<TrsMethodEpisOffline> getTrsMethod() {
		return trsMethod;
	}
	public void setTrsMethod(List<TrsMethodEpisOffline> trsMethod) {
		this.trsMethod = trsMethod;
	}
	public String getManualID() {
		return manualID;
	}
	public void setManualID(String manualID) {
		this.manualID = manualID;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public String getCreatBy() {
		return creatBy;
	}

	public void setCreatBy(String creatBy) {
		this.creatBy = creatBy;
	}

	
	

}
