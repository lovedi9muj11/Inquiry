package th.co.maximus.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("ReciptNoGenCode")
public class ReciptNoGenCode {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Value("${text.prefix}")
	private String nameCode;
	@Value("${text.posno}")
	private String posNo;
	@Value("${text.branarea}")
	private String branArea;
	
	public String genCodeRecipt(String docType) {
		StringBuilder sql = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd", new Locale("en", "US" ));
		String date = sdf.format(new Date());
		
		
		int result = 0;
		
		
		SimpleDateFormat datea = new SimpleDateFormat("yyMMdd");
		String dateS = datea.format(new Date());
		
		String dates=convertDateString(dateS);
		try {

			sql.append(" SELECT COUNT(pm.RECEIPT_NO_MANUAL) AS ReciptCount FROM receipt_manual pm ");
			sql.append(" WHERE pm.CREATE_DATE >= ' ").append(convertDateString(date.toString()))
					.append(" 00:00:00.000000' ");
			sql.append(" AND pm.CREATE_DATE <= ' ").append(convertDateString(date.toString()))
					.append(" 23:59:59.999999' ");
			result = jdbcTemplate.queryForObject(sql.toString(), Integer.class);
		} catch (Exception e) {
			String zeron = "";
			if(result >9) {
				zeron ="00"+result;
			}else {
				zeron ="000"+result;
			}
			String codeName = nameCode+posNo+branArea + docType+dates+zeron;		
			return codeName;
		}
		String zeron = "";
		if(result >9) {
			zeron ="00"+result;
		}else {
			zeron ="000"+result;
		}
		String codeName = nameCode+posNo+branArea + docType+dates+zeron;		
		return codeName;
	}

	public static final String convertDateString(String str) {
		return str.replaceAll("([0-9]{2})/([0-9]{2})/([0-9]{4})", "$3-$2-$1");

	} 

}
