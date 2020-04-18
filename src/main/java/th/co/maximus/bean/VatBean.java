package th.co.maximus.bean;

import java.math.BigDecimal;

public class VatBean {
	
	private String vatRat;
	private String vatRatStr;
	private BigDecimal vatAmount;
	private String vatAmountStr;
	private BigDecimal amount;
	private String amountStr;
	private BigDecimal sumAmount;
	private String sumAmountStr;
	private int count;
	
	public String getVatRat() {
		return vatRat;
	}
	public void setVatRat(String vatRat) {
		this.vatRat = vatRat;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getAmountStr() {
		return amountStr;
	}
	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}
	public BigDecimal getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(BigDecimal sumAmount) {
		this.sumAmount = sumAmount;
	}
	public String getSumAmountStr() {
		return sumAmountStr;
	}
	public void setSumAmountStr(String sumAmountStr) {
		this.sumAmountStr = sumAmountStr;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getVatRatStr() {
		return vatRatStr;
	}
	public void setVatRatStr(String vatRatStr) {
		this.vatRatStr = vatRatStr;
	}
	public BigDecimal getVatAmount() {
		return vatAmount;
	}
	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}
	public String getVatAmountStr() {
		return vatAmountStr;
	}
	public void setVatAmountStr(String vatAmountStr) {
		this.vatAmountStr = vatAmountStr;
	}

}
