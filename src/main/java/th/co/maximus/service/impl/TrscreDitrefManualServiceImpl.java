package th.co.maximus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.TrscreDitrefManualBean;
import th.co.maximus.service.TrscreDitrefManualService;

@Service
public class TrscreDitrefManualServiceImpl implements TrscreDitrefManualService{
	
private JdbcTemplate jdbcTemplate;
	
	public TrscreDitrefManualServiceImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertTrscreDitrefManua(TrscreDitrefManualBean trscreDitrefManualBean) {
		String sql = "INSERT INTO payment_manual (ID, CREDITNO, PUBLISHERDEC, CARDTYPE, AMOUNT, UPDATEDTTM, UPDATESYSTEM, UPDATEUSER, VERSIONSTAMP, METHOD_MANUAL_ID)  VALUES (?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, trscreDitrefManualBean.getId(), trscreDitrefManualBean.getCreditNo(), trscreDitrefManualBean.getPublisherdec());
	
	}
	
	@Override
	public List<TrscreDitrefManualBean> TrscreDitrefManualAll() {
		return jdbcTemplate.query("select * from payment_manual", new TrscreDitrefManualJoin());
	}
	
	/*public PaymentManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentManuaJoin());
	}*/
	
	private static final class TrscreDitrefManualJoin implements RowMapper<TrscreDitrefManualBean> {

		@Override
		public TrscreDitrefManualBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			TrscreDitrefManualBean manualBean = new TrscreDitrefManualBean();
			manualBean.setId(rs.getLong("ID"));
			manualBean.setCreditNo(rs.getString("CREDITNO"));
			manualBean.setPublisherdec(rs.getString("PUBLISHERDEC"));
			manualBean.setCardType(rs.getString("CARDTYPE"));
			manualBean.setaMount(rs.getLong("AMOUNT"));
			manualBean.setUpdateDttm(rs.getTimestamp("UPDATEDTTM"));
			manualBean.setUpdateSystem(rs.getString("UPDATESYSTEM"));
			manualBean.setUpdateUser(rs.getString("UPDATEUSER"));
			manualBean.setVersionStamp(rs.getLong("VERSIONSTAMP"));
			manualBean.setMethodManualId(rs.getString("METHOD_MANUAL_ID"));
			
			
			return manualBean;
		}

	}

}
