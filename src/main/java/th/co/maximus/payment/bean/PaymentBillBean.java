package th.co.maximus.payment.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaymentBillBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String inputServiceType;
	private String inputServiceDepartment;
	private BigDecimal inputServiceDiscount;
	private String inputServiceName;
	private Integer inputServiceMoreData;
	private String inputServiceUnit;
	private BigDecimal inputSpecialDiscount;
	private double inputServiceAmount;
	private BigDecimal inputServiceDeduction;
	private Integer vatrate;
	
	private double inputsumWt;
	
	public double getInputsumWt() {
		return inputsumWt;
	}
	public void setInputsumWt(double inputsumWt) {
		this.inputsumWt = inputsumWt;
	}
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
	public BigDecimal getInputServiceDiscount() {
		return inputServiceDiscount;
	}
	public void setInputServiceDiscount(BigDecimal inputServiceDiscount) {
		this.inputServiceDiscount = inputServiceDiscount;
	}
	public String getInputServiceName() {
		return inputServiceName;
	}
	public void setInputServiceName(String inputServiceName) {
		this.inputServiceName = inputServiceName;
	}
	public Integer getInputServiceMoreData() {
		return inputServiceMoreData;
	}
	public void setInputServiceMoreData(Integer inputServiceMoreData) {
		this.inputServiceMoreData = inputServiceMoreData;
	}
	public String getInputServiceUnit() {
		return inputServiceUnit;
	}
	public void setInputServiceUnit(String inputServiceUnit) {
		this.inputServiceUnit = inputServiceUnit;
	}
	public BigDecimal getInputSpecialDiscount() {
		return inputSpecialDiscount;
	}
	public void setInputSpecialDiscount(BigDecimal inputSpecialDiscount) {
		this.inputSpecialDiscount = inputSpecialDiscount;
	}
	public double getInputServiceAmount() {
		return inputServiceAmount;
	}
	public void setInputServiceAmount(double inputServiceAmount) {
		this.inputServiceAmount = inputServiceAmount;
	}
	public BigDecimal getInputServiceDeduction() {
		return inputServiceDeduction;
	}
	public void setInputServiceDeduction(BigDecimal inputServiceDeduction) {
		this.inputServiceDeduction = inputServiceDeduction;
	}
	public Integer getVatrate() {
		return vatrate;
	}
	public void setVatrate(Integer vatrate) {
		this.vatrate = vatrate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
