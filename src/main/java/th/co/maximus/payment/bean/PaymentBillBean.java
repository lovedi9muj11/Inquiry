package th.co.maximus.payment.bean;

import java.io.Serializable;

public class PaymentBillBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String inputServiceType;
	private String inputServiceDepartment;
	private double inputServiceDiscount;
	private String inputServiceName;
	private String inputServiceMoreData;
	private String inputServiceUnit;
	private double inputSpecialDiscount;
	private double inputServiceAmount;
	private double inputServiceDeduction;
	private String vatrate;
	private String vatRadio;
	public String getInputServiceType() {
		return inputServiceType;
	}
	public void setInputServiceType(String inputServiceType) {
		this.inputServiceType = inputServiceType;
	}
	public String getInputServiceDepartment() {
		return inputServiceDepartment;
	}
	public void setInputServiceDepartment(String inputServiceDepartment) {
		this.inputServiceDepartment = inputServiceDepartment;
	}
	public double getInputServiceDiscount() {
		return inputServiceDiscount;
	}
	public void setInputServiceDiscount(double inputServiceDiscount) {
		this.inputServiceDiscount = inputServiceDiscount;
	}
	public String getInputServiceName() {
		return inputServiceName;
	}
	public void setInputServiceName(String inputServiceName) {
		this.inputServiceName = inputServiceName;
	}
	public String getInputServiceMoreData() {
		return inputServiceMoreData;
	}
	public void setInputServiceMoreData(String inputServiceMoreData) {
		this.inputServiceMoreData = inputServiceMoreData;
	}
	public String getInputServiceUnit() {
		return inputServiceUnit;
	}
	public void setInputServiceUnit(String inputServiceUnit) {
		this.inputServiceUnit = inputServiceUnit;
	}
	public double getInputSpecialDiscount() {
		return inputSpecialDiscount;
	}
	public void setInputSpecialDiscount(double inputSpecialDiscount) {
		this.inputSpecialDiscount = inputSpecialDiscount;
	}
	public double getInputServiceAmount() {
		return inputServiceAmount;
	}
	public void setInputServiceAmount(double inputServiceAmount) {
		this.inputServiceAmount = inputServiceAmount;
	}
	public double getInputServiceDeduction() {
		return inputServiceDeduction;
	}
	public void setInputServiceDeduction(double inputServiceDeduction) {
		this.inputServiceDeduction = inputServiceDeduction;
	}
	public String getVatrate() {
		return vatrate;
	}
	public void setVatrate(String vatrate) {
		this.vatrate = vatrate;
	}
	public String getVatRadio() {
		return vatRadio;
	}
	public void setVatRadio(String vatRadio) {
		this.vatRadio = vatRadio;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
