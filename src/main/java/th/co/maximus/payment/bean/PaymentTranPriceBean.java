package th.co.maximus.payment.bean;

import java.io.Serializable;
import java.util.Date;

public class PaymentTranPriceBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String typePayment;
	private double moneyTran;
	private String creditType;
	private String creditNo;
	private String edcType;
	private double creditPrice;
	private String bankNo;
	private String checkNo;
	private String bankName;
	private Date dateCheck;
	private String branchCheck;
	private double moneyCheck;
	public String getTypePayment() {
		return typePayment;
	}
	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}
	public double getMoneyTran() {
		return moneyTran;
	}
	public void setMoneyTran(double moneyTran) {
		this.moneyTran = moneyTran;
	}
	public String getCreditType() {
		return creditType;
	}
	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}
	public String getCreditNo() {
		return creditNo;
	}
	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}
	public String getEdcType() {
		return edcType;
	}
	public void setEdcType(String edcType) {
		this.edcType = edcType;
	}
	public double getCreditPrice() {
		return creditPrice;
	}
	public void setCreditPrice(double creditPrice) {
		this.creditPrice = creditPrice;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getCheckNo() {
		return checkNo;
	}
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Date getDateCheck() {
		return dateCheck;
	}
	public void setDateCheck(Date dateCheck) {
		this.dateCheck = dateCheck;
	}
	public String getBranchCheck() {
		return branchCheck;
	}
	public void setBranchCheck(String branchCheck) {
		this.branchCheck = branchCheck;
	}
	public double getMoneyCheck() {
		return moneyCheck;
	}
	public void setMoneyCheck(double moneyCheck) {
		this.moneyCheck = moneyCheck;
	}

	
}
