package th.co.maximus.core.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
	
	public static String periodFormat(String req) {
		String result = "";
		if(req.length()==16) {
			result += req.substring(6, 8).concat("/");
			result += req.substring(4, 6).concat("/");
			result += req.substring(0, 4).concat(" - ");
			
			result += req.substring(14, 16).concat("/");
			result += req.substring(12, 14).concat("/");
			result += req.substring(8, 12);
		}
		 return result;
	}
	
	public String formatAmount(BigDecimal req) {
		NumberFormat formatter = new DecimalFormat("#0,000.00");
		return formatter.format(req);
	}
}
