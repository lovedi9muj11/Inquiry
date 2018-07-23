package th.co.maximus.constants;

import java.util.Locale;

public class Constants {
	
	public static final String TEST = "TEST";
	public static final Locale localeTH = new Locale("th", "TH");
	public static final Locale localeEN = new Locale("en", "EN");
	public static final String SUCCESS = "SUCCESS";
	
	/** The Constant BLANK. */
	public static final String BLANK = "";
	
	/** The Constant COLON. */
	public static final String COLON = " : ";
	
	/** The Constant DASH. */
	public static final String DASH = " - ";
	
	/** The Constant KEY_TXNID. */
	public static final String KEY_TXNID = "TXNID";
	
	/** The Constant XPATH_TXNID. */
	public static final String XPATH_TXNID = "//transcationId";
	
	/** The Constant ENTRY. */
	public static final String ENTRY = "Entry";
	
	/** The Constant EXIT. */
	public static final String EXIT = "Exit";
	
	
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
		public static final String ACTIVE_ = " - ";
		
		public static final String METHOD_WT_STR = "ภาษีหัก ณ ที่จ่าย";
		public static final String METHOD_WT = "WT";
	}
	
	public static class report{
		public static final String repotPathc = "/report/jasper/pdf";
		public static final String EXCELFULL = "ExcelFull";
		public static final String XXX = "RPTxxx";
		public static final String REPORT_FULL = "Report";
		public final static String RPT_EXCEL = "EXCEL";
	}
	public static class dataUser{
		public static final String BRANCHAREA = "1704";
		public static final String SOURCE = "OFFLINE";
		public static final String NAME_USER = "ADMIN";
	}
	
	public static class Service{
		public static final String SERVICE_TYPE_IBACSS = "IBACSS";
		public static final String SERVICE_TYPE_OTHER = "OTHER";
		
		public static final String CENTER_SERVICE = "ศูนย์บริการลูกค้า";
		public static final String CENTER_SERVICE_ = "ศบล.";
	}
	
	public static class MasterData{
		public static final String SELECT_DROPDOWN = "กรุณาเลือก";
		public static final String MASTERDATA_GROUP = "INITVALUE";
		public static final String STATUS_SUCCESS = "SUCCESS";
		public static final String STATUS_FAIL = "FAIL";
		public static final String BANK_TYPE = "BANK_TYPE";
		public static final String OTHER = "OTHER";
		public static final String BUSINESS_AREA = "BUSINESS_AREA";
		public static final String COST_CENTER = "COST_CENTER";
		public static final String OTHER_PAYMENT_UNIT = "OTHER_PAYMENT_UNIT";
		public static final String TRIGGER_GOUP = "TriggerGoup";
		
		public static class KEYCODE{
			public static final String TRIGGER_MS = "Trigger_MS";
			public static final String TRIGGER_GL = "Trigger_GL";
			public static final String TRIGGER_USER = "Trigger_User";
			public static final String TRIGGER_MINUS = "Trigger_Minus";
		}
		
	}
	
	public static class GL_SERVICE{
		public static final String OTHER = "OTHER";
	}
	
	public static class Role{
		public static final String SUPPERVISOR = "sup";
		public static final String ADMIN = "admin";
		public static final String USER = "user";
		
		public static class RoleOnline{
			public static final String SUPPERVISOR = "Suppervisor";
			public static final String ADMIN = "ADMIN";
			public static final String USER = "BACKOFFICE";
			
			
		}
	}
	
	public static class CANCEL{
		public static final String CANCEL_SERVICE_01 = "01";
		public static final String CANCEL_ADDR_02 = "02";
		public static final String CANCEL_SERVICE = "รับชำระผิดบริการ";
		public static final String CANCEL_ADDR = "ชื่อ-ที่อยู่ ไม่ถูกต้อง";
	}
	
	public static class BATCH{
		public static final String JOB_1 = "jobWithSimpleTriggerBeanTrigger";
		public static final String JOB_2 = "jobWithSimpleTriggerBeanTrigger2";
		public static final String JOB_3 = "jobWithSimpleTriggerBeanTrigger3";
		public static final String JOB_4 = "jobWithSimpleTriggerBeanTrigger4";
	}

}
