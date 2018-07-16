package th.co.maximus.bean;

public class ReportPaymentCriteria {
	private String dateFrom;
	private String dateTo;
	private String accountId;
	private String vatRate;
	private String user;
	private String serviceType;
	private String machinePaymentName;
	
	private String firstName;
	private String lastName;
	
	public String getMachinePaymentName() {
		return machinePaymentName;
	}
	public void setMachinePaymentName(String machinePaymentName) {
		this.machinePaymentName = machinePaymentName;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getVatRate() {
		return vatRate;
	}
	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
