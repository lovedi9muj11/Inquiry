package th.co.maximus.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_invoice_manual")
public class PaymentInvoiceManualModel {
	private  Long   paymentInvoiceManualId;
	private  Long   manualId;
	private  String   source;
	private  String  invoiceNo;
	private  Long  beforVat;
	private  Long   amount;
	private  Long   vatAmount;
	private  int   vatRate;
	private  int   customerName;
	private  String  customerAddress;
	private  String  customerSegment;
	private  String  customerBranch;
	private  String  taxNo;
	private  String  subNo;
	private  String  period;
	private  String  serviceType;
	private  String   clearing;
	private  String   printReceipt;
	private  String   remark;
	private  String   createBy;
	private  Timestamp   createDate;
	private  String   updateBy;
	private  Timestamp   updateDate;
	private  String   recordStatus;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPaymentInvoiceManualId() {
		return paymentInvoiceManualId;
	}
	public void setPaymentInvoiceManualId(Long paymentInvoiceManualId) {
		this.paymentInvoiceManualId = paymentInvoiceManualId;
	}
	
	public Long getManualId() {
		return manualId;
	}
	public void setManualId(Long manualId) {
		this.manualId = manualId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Long getBeforVat() {
		return beforVat;
	}
	public void setBeforVat(Long beforVat) {
		this.beforVat = beforVat;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getVatAmount() {
		return vatAmount;
	}
	public void setVatAmount(Long vatAmount) {
		this.vatAmount = vatAmount;
	}
	public int getVatRate() {
		return vatRate;
	}
	public void setVatRate(int vatRate) {
		this.vatRate = vatRate;
	}
	public int getCustomerName() {
		return customerName;
	}
	public void setCustomerName(int customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerSegment() {
		return customerSegment;
	}
	public void setCustomerSegment(String customerSegment) {
		this.customerSegment = customerSegment;
	}
	public String getCustomerBranch() {
		return customerBranch;
	}
	public void setCustomerBranch(String customerBranch) {
		this.customerBranch = customerBranch;
	}
	public String getTaxNo() {
		return taxNo;
	}
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	public String getSubNo() {
		return subNo;
	}
	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getClearing() {
		return clearing;
	}
	public void setClearing(String clearing) {
		this.clearing = clearing;
	}
	public String getPrintReceipt() {
		return printReceipt;
	}
	public void setPrintReceipt(String printReceipt) {
		this.printReceipt = printReceipt;
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
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	
	
}
