package th.co.maximus.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RECEIPT_MANUAL")
public class PaymentMaualModel {
	
	private  Long   manualId;
	
	private  Long   paymentId;
	private  String  invoiceNo;
	private  String  receiptNoManual;
	private  Timestamp   paidDate;
	private  String   brancharea;
	private  String   branchCode;
	private  Long  paidAmount;
	private  String  source;
	private  String  clearing;
	private  String  remark;
	private  String  createBy;
	private  Timestamp  createDate;
	private  String  updateBy;
	private  Timestamp   updateDate;
	private  String   recordBtatus;
	private  Long   refid;
	private  String   accountNo;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MANUAL_ID")
	public Long getManualId() {
		return manualId;
	}
	public void setManualId(Long manualId) {
		this.manualId = manualId;
	}
	@Column(name = "PAYMENT_ID")
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	@Column(name = "INVOICE_NO")
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@Column(name = "RECEIPT_NO_MANUAL")
	public String getReceiptNoManual() {
		return receiptNoManual;
	}
	public void setReceiptNoManual(String receiptNoManual) {
		this.receiptNoManual = receiptNoManual;
	}
	@Column(name = "PAID_DATE")
	public Timestamp getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Timestamp paidDate) {
		this.paidDate = paidDate;
	}
	@Column(name = "BRANCH_AREA")
	public String getBrancharea() {
		return brancharea;
	}
	public void setBrancharea(String brancharea) {
		this.brancharea = brancharea;
	}
	@Column(name = "BRANCH_CODE")
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	@Column(name = "PAID_AMOUNT")
	public Long getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Long paidAmount) {
		this.paidAmount = paidAmount;
	}
	@Column(name = "SOURCE")
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Column(name = "CLEARING")
	public String getClearing() {
		return clearing;
	}
	public void setClearing(String clearing) {
		this.clearing = clearing;
	}
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "CREATE_BY")
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Column(name = "CREATE_DATE")
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	@Column(name = "UPDATE_BY")
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	@Column(name = "UPDATE_DATE")
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	@Column(name = "RECORD_STATUS")
	public String getRecordBtatus() {
		return recordBtatus;
	}
	public void setRecordBtatus(String recordBtatus) {
		this.recordBtatus = recordBtatus;
	}
	@Column(name = "REF_ID")
	public Long getRefid() {
		return refid;
	}
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	@Column(name = "ACCOUNT_NO")
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
//	@Column(name = "BRANCH_AREA")
//	public String getClearingSap() {
//		return clearingSap;
//	}
//
//	public void setClearingSap(String clearingSap) {
//		this.clearingSap = clearingSap;
//	}
//	
	
	
}
