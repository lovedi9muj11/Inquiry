package th.co.maximus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "correceiptdocument")
public class CorreceiptDocumentModel {
	private  Long   receiptDocumentId;
	private  String   receiptDocumentType;
	private  String   receiptHeader	;
	private  String  branchArea;
	private  String  datetext;
	private  Long   documentCount;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getReceiptDocumentId() {
		return receiptDocumentId;
	}
	public void setReceiptDocumentId(Long receiptDocumentId) {
		this.receiptDocumentId = receiptDocumentId;
	}
	public String getReceiptDocumentType() {
		return receiptDocumentType;
	}
	public void setReceiptDocumentType(String receiptDocumentType) {
		this.receiptDocumentType = receiptDocumentType;
	}
	public String getReceiptHeader() {
		return receiptHeader;
	}
	public void setReceiptHeader(String receiptHeader) {
		this.receiptHeader = receiptHeader;
	}
	public String getBranchArea() {
		return branchArea;
	}
	public void setBranchArea(String branchArea) {
		this.branchArea = branchArea;
	}
	public String getDatetext() {
		return datetext;
	}
	public void setDatetext(String datetext) {
		this.datetext = datetext;
	}
	public Long getDocumentCount() {
		return documentCount;
	}
	public void setDocumentCount(Long documentCount) {
		this.documentCount = documentCount;
	}
	
	
}
