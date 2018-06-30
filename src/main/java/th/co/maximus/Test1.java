package th.co.maximus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;

import java.text.ParseException;
public class Test1 {

public static void main(String[] args) {
		
		String sDate = "2013-08-12";
		
//		System.out.println("Date Thai : " + dateThai(sDate));
		
		Map<String,String> dateStr = dateThai(sDate);
		System.out.println("DAY Thai : " + dateStr.get("DAY"));
		System.out.println("MONTH Thai : " + dateStr.get("MONTH"));
		System.out.println("YEAR Thai : " + dateStr.get("YEAR"));

	}
	
	public static  Map<String,String> dateThai(String strDate)
	{
		String Months[] = {
			      "ม.ค", "ก.พ", "มี.ค", "เม.ย",
			      "พ.ค", "มิ.ย", "ก.ค", "ส.ค",
			      "ก.ย", "ต.ค", "พ.ย", "ธ.ค"};
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		
		int year=0,month=0,day=0;
		try {
			Date date = df.parse(strDate);
			Calendar c = Calendar.getInstance();
			c.setTime(date);  
			
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH);
			day = c.get(Calendar.DATE);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,String> a= new HashMap(); 
		a.put("DAY", day+"");
		a.put("MONTH", Months[month]);
		a.put("YEAR",year+"");
		return a;
	}
}
