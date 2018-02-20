package th.co.maximus.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("ReciptNoGenCode")
public class ReciptNoGenCode {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int genCodeRecipt() {
		StringBuilder sql = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String date = sdf.format(new Date());
		int result = 0;
		try {

			sql.append(" SELECT COUNT(pm.RECEIPT_NO_MANUAL) AS ReciptCount FROM payment_manual pm ");
			sql.append(" WHERE pm.CREATE_DATE >= ' ").append(convertDateString(date.toString()))
					.append(" 00:00:00.000000' ");
			sql.append(" AND pm.CREATE_DATE <= ' ").append(convertDateString(date.toString()))
					.append(" 23:59:59.999999' ");
			result = jdbcTemplate.queryForObject(sql.toString(), Integer.class);
		} catch (Exception e) {
			return result;
		}

		return result;
	}

	public static final String convertDateString(String str) {
		return str.replaceAll("([0-9]{2})/([0-9]{2})/([0-9]{4})", "$3-$2-$1");

	}

}
