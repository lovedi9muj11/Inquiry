package th.co.maximus.bean;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import th.co.maximus.core.utils.converter.CustomDateTimeDeserializer;
import th.co.maximus.core.utils.converter.CustomDateTimeSerializer;

public class HistorySubFindBean {
	
	private Date payDate;
	private Date payDateTo;
	private String accountCode;
	private String vatRate;
	private String pos;
	private String user;
	private String payType;
	
	public String getAccountCode() {
		return accountCode;
	}
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	public String getVatRate() {
		return vatRate;
	}
	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public Date getPayDate() {
		return payDate;
	}
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getPayDateTo() {
		return payDateTo;
	}
	public void setPayDateTo(Date payDateTo) {
		this.payDateTo = payDateTo;
	}

}
