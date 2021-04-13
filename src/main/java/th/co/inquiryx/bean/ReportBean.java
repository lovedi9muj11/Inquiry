package th.co.inquiryx.bean;

public class ReportBean {
	
	private Long reportId;
	private String userName;
	private String name;
	
	//
	private String dateFrom;
	private String dateFromHour;
	private String dateFromMinute;
	private String dateTo;
	private String dateToHour;
	private String dateToMinute;
	private String typePrint;
	private String rptCode;
	
	public Long getReportId() {
		return reportId;
	}
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateFromHour() {
		return dateFromHour;
	}
	public void setDateFromHour(String dateFromHour) {
		this.dateFromHour = dateFromHour;
	}
	public String getDateFromMinute() {
		return dateFromMinute;
	}
	public void setDateFromMinute(String dateFromMinute) {
		this.dateFromMinute = dateFromMinute;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getDateToHour() {
		return dateToHour;
	}
	public void setDateToHour(String dateToHour) {
		this.dateToHour = dateToHour;
	}
	public String getDateToMinute() {
		return dateToMinute;
	}
	public void setDateToMinute(String dateToMinute) {
		this.dateToMinute = dateToMinute;
	}
	public String getTypePrint() {
		return typePrint;
	}
	public void setTypePrint(String typePrint) {
		this.typePrint = typePrint;
	}
	public String getRptCode() {
		return rptCode;
	}
	public void setRptCode(String rptCode) {
		this.rptCode = rptCode;
	}
	
}