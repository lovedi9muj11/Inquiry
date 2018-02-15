package th.co.maximus.core.utils;

public class Utils {
	
	public String periodFormat(String req) {
		String result = "";
		if(req.length()==16) {
			result += req.substring(4, 6).concat("/");
			result += req.substring(6, 8).concat("/");
			result += req.substring(0, 4).concat(" - ");
			
			result += req.substring(12, 14).concat("/");
			result += req.substring(14, 16).concat("/");
			result += req.substring(8, 12);
		}
		 return result;
	}
}
