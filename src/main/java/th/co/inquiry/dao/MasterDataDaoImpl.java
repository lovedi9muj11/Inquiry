package th.co.inquiry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import th.co.inquiryx.bean.MasterDataBean;

@Service
public class MasterDataDaoImpl implements MasterDataDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<MasterDataBean> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA  ");
//		sql.append(" WHERE ms.groupType = 'INITVALUE' ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	
	@Override
	public int insertMasterdata(MasterDataBean masterDataBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO MASTER_DATA (KEYCODE, VALUE, GROUP_KEY, TYPE, SCORE)  VALUES (?,?,?,?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "id" });
				pst.setString(1, masterDataBean.getKeyCode());
				pst.setString(2, masterDataBean.getValue());
				pst.setString(3, masterDataBean.getGroup());
				pst.setString(4, masterDataBean.getType());
				pst.setString(5, masterDataBean.getScore());
				return pst;
			}
		}, keyHolder);
		int newUserId = keyHolder.getKey().intValue();
		return newUserId;
	}
	
	@Override
	public int insertMasterdataGroup(MasterDataBean masterDataBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO MASTER_DATA (KEYCODE, VALUE, TYPE)  VALUES (?,?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "id" });
				pst.setString(1, masterDataBean.getKeyCode());
				pst.setString(2, masterDataBean.getValue());
				pst.setString(3, masterDataBean.getType());
				return pst;
			}
		}, keyHolder);
		int newUserId = keyHolder.getKey().intValue();
		return newUserId;
	}
	
	@Override
	public List<MasterDataBean> findAllByGropType(String groupType) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA ms  ");
		sql.append(" WHERE ms.KEYCODE = ");
		sql.append("'"+groupType+"'");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	
	private static final class masterData implements RowMapper<MasterDataBean> {

		@Override
		public MasterDataBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			MasterDataBean masterDataBean = new MasterDataBean();
			masterDataBean.setId(rs.getInt("id"));
			masterDataBean.setValue(rs.getString("KEYCODE"));
			masterDataBean.setText(rs.getString("VALUE"));
			masterDataBean.setGroup(rs.getString("GROUP_KEY"));
			masterDataBean.setType(rs.getString("TYPE"));
			masterDataBean.setScore(rs.getString("SCORE"));
			return masterDataBean;
		}

	}
	
	@Override
	public MasterDataBean findGroupTypeByKeyCode(String groupKey) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA WHERE 1=1 and KEYCODE = '"+groupKey+"'");
		
		return jdbcTemplate.queryForObject(sql.toString(), new masterData());
	}

	@Override
	public void updateMasterdata(MasterDataBean masterDataBean) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" UPDATE MASTER_DATA set KEYCODE = ?, VALUE = ?, GROUP_KEY = ?, TYPE = ?, SCORE = ? WHERE ID = ?");
		
		param.add(masterDataBean.getKeyCode());
		param.add(masterDataBean.getValue());
		param.add(masterDataBean.getGroup());
		param.add(masterDataBean.getType());
		param.add(masterDataBean.getScore());
		param.add(masterDataBean.getId());
		Object[] paramArr = param.toArray();
		
		jdbcTemplate.update(sql.toString(), paramArr);
	}

	@Override
	public void delete(int id) {
		String delsql = "DELETE FROM MASTER_DATA WHERE ID = "+id;
		jdbcTemplate.update(delsql);
	}

	@Override
	public List<MasterDataBean> findAllByGropKey(String groupKey) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA WHERE 1=1 and GROUP_KEY = '"+groupKey+"'");
		
		return jdbcTemplate.query(sql.toString(), new masterData());
	}

	@Override
	public MasterDataBean findGroupTypeByKeyCode(String groupKey, String keyCode) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA WHERE 1=1 and KEYCODE = '"+keyCode+"'");
		sql.append(" and GROUP_KEY = '"+groupKey+"'");
		
		return jdbcTemplate.queryForObject(sql.toString(), new masterData());
	}

	@Override
	public List<MasterDataBean> findAllQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

}
