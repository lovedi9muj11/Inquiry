package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.DropDownBean;
import th.co.maximus.constants.Constants;

@Service
public class CancelDaoImp implements CancelDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final class DropdownMap implements RowMapper<DropDownBean> {

		@Override
		public DropDownBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DropDownBean dropDownBean = new DropDownBean();
			dropDownBean.setKey(rs.getString("KEYCODE"));
			dropDownBean.setValue(rs.getString("VALUE"));
			return dropDownBean;
		}

	}
	
	@Override
	public List<DropDownBean> reasonCancelIbacss() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA WHERE 1=1 and GROUP_KEY = '"+Constants.MasterData.IBACSS_CANCEL_REASON+"'");
		sql.append(" and PROPERTY_1 = '"+Constants.MasterData.CANCEL_REASON_INDAY+"'");
		
		return jdbcTemplate.query(sql.toString() , new DropdownMap());
	}

	@Override
	public List<DropDownBean> reasonCancelOther() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA WHERE 1=1 and GROUP_KEY = '"+Constants.MasterData.OTHER_CANCEL_REASON+"'");
		sql.append(" and PROPERTY_1 = '"+Constants.MasterData.CANCEL_REASON_INDAY+"'");

		return jdbcTemplate.query(sql.toString() , new DropdownMap());
	}

}
