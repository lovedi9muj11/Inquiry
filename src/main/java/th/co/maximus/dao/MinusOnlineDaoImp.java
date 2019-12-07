package th.co.maximus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;

@Service
public class MinusOnlineDaoImp implements MinusOnlineDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void updateStatusForMinusOnline(PaymentMMapPaymentInvBean creteria) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE receipt_manual ");
		sql.append(" SET CLEARING =  ? ");
		sql.append(" WHERE MANUAL_ID = ? ");
		
		jdbcTemplate.update(sql.toString(), "W", creteria.getManualId());
	}

}
