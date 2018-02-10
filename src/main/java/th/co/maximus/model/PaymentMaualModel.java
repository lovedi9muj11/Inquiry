package th.co.maximus.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_manual")
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
	private  String   clearingSap;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getManualId() {
		return manualId;
	}
	public void setManualId(Long manualId) {
		this.manualId = manualId;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getReceiptNoManual() {
		return receiptNoManual;
	}
	public void setReceiptNoManual(String receiptNoManual) {
		this.receiptNoManual = receiptNoManual;
	}
	public Timestamp getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Timestamp paidDate) {
		this.paidDate = paidDate;
	}
	public String getBrancharea() {
		return brancharea;
	}
	public void setBrancharea(String brancharea) {
		this.brancharea = brancharea;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public Long getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Long paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getClearing() {
		return clearing;
	}
	public void setClearing(String clearing) {
		this.clearing = clearing;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public String getRecordBtatus() {
		return recordBtatus;
	}
	public void setRecordBtatus(String recordBtatus) {
		this.recordBtatus = recordBtatus;
	}
	public Long getRefid() {
		return refid;
	}
	public void setRefid(Long refid) {
		this.refid = refid;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getClearingSap() {
		return clearingSap;
	}
	public void setClearingSap(String clearingSap) {
		this.clearingSap = clearingSap;
	}
	
	
	
}
