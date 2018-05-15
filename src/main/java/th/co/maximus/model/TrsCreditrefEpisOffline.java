package th.co.maximus.model;

import java.math.BigDecimal;

public class TrsCreditrefEpisOffline {

	private String creditNo;
	private String publisherdec;
	private String cardtype;
	private BigDecimal amount;
	
	public TrsCreditrefEpisOffline(){}
	public TrsCreditrefEpisOffline(String creditNo,String publisherdec,String cardtype,BigDecimal amount){
		this.creditNo = creditNo;
		this.publisherdec = publisherdec;
		this.cardtype = cardtype;
		this.amount = amount;
	}
	public String getCreditNo() {
		return creditNo;
	}
	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}
	public String getPublisherdec() {
		return publisherdec;
	}
	public void setPublisherdec(String publisherdec) {
		this.publisherdec = publisherdec;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}
