package th.co.maximus.model;

import java.math.BigDecimal;
import java.util.Date;

public class TrsChequerefEpisOffline {
	private String chequeNo;
	private String publisherid;
	private String publisher;
	private String branch;
	private BigDecimal amount;
	private Date chequeDate;
	private Date bounceChequeDate;
	private Date reverseArDate;
	private String bounceStatus;
	
	public TrsChequerefEpisOffline(){}
	public TrsChequerefEpisOffline(String chequeNo,String publisherid,String publisher,String branch,BigDecimal amount,Date chequeDate
			,Date bounceChequeDate,Date reverseArDate,String bounceStatus){
		
		this.chequeNo = chequeNo;
		this.publisherid = publisherid;
		this.publisher = publisher;
		this.branch = branch;
		this.amount = amount;
		this.chequeDate = chequeDate;
		this.bounceChequeDate = bounceChequeDate;
		this.reverseArDate = reverseArDate;
		this.bounceStatus = bounceStatus;
	}
	
	public String getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getPublisherid() {
		return publisherid;
	}
	public void setPublisherid(String publisherid) {
		this.publisherid = publisherid;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getBounceStatus() {
		return bounceStatus;
	}
	public void setBounceStatus(String bounceStatus) {
		this.bounceStatus = bounceStatus;
	}
	public Date getChequeDate() {
		return chequeDate;
	}
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}
	public Date getBounceChequeDate() {
		return bounceChequeDate;
	}
	public void setBounceChequeDate(Date bounceChequeDate) {
		this.bounceChequeDate = bounceChequeDate;
	}
	public Date getReverseArDate() {
		return reverseArDate;
	}
	public void setReverseArDate(Date reverseArDate) {
		this.reverseArDate = reverseArDate;
	}

	
	
	
}
