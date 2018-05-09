package th.co.maximus.constants;

import java.util.Locale;

public class Constants {
	
	public static final String TEST = "TEST";
	public static final Locale localeTH = new Locale("th", "TH");
	public static final Locale localeEN = new Locale("en", "EN");
	
	
	public static class DateTime {
		public static final String LOCALE = "TH";
		public static final String DATE_FORMAT = "dd/MM/yyyy";
		public static final String DATE_LONG_FORMAT = "dd MMMM yyyy";
		public static final String TIME_FORMAT = "HH:mm:ss";
		public static final String DB_DATE_FORMAT = "yyyy-MM-dd";
		public static final String D_DB_DATE_FORMAT = "dd-MM-yyyy";
		public static final String DB_TIME_FORMAT = "HH:mm:ss";
		public static final String OFFLINE = "OFFLINE";
	}

	public static class Status {
		public static final String ACTIVE = "A";
		public static final String ACTIVE_A = "ปกติ";
		public static final String ACTIVE_C = "ยกเลิก";
		public static final String ACTIVE_AC = "รอหักล้าง";
	}
	
	public static class report{
		public static final String repotPathc = "/report/jasper/pdf";
		public static final String EXCELFULL = "ExcelFull";
		public static final String XXX = "RPTxxx";
		public static final String REPORT_FULL = "Report";
		public final static String RPT_EXCEL = "EXCEL";
	}
	public static class dataUser{
		public static final String BRANCHAREA = "CAT นนทบุรี";
		public static final String SOURCE = "OFFLINE";
		public static final String NAME_USER = "ADMIN";
	}
	
	public static class Service{
		public static final String SERVICE_TYPE_IBACSS = "IBACSS";
	}
	
	public static class MasterData{
		public static final String SELECT_DROPDOWN = "กรุณาเลือก";
		public static final String MASTERDATA_GROUP = "INITVALUE";
		public static final String STATUS_SUCCESS = "SUCCESS";
		public static final String STATUS_FAIL = "FAIL";
		public static final String BANK_TYPE = "BANK_TYPE";
		public static final String OTHER = "OTHER";
		public static final String BUSINESS_AREA = "BUSINESS_AREA";
		public static final String OTHER_PAYMENT_UNIT = "OTHER_PAYMENT_UNIT";
	}
	
}
