package th.co.inquiry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import th.co.inquiry.model.ScoreBean;
import th.co.inquiryx.bean.MasterDataBean;

@Service
public class ScoreDaoImpl implements ScoreDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MasterDataDao masterDataDao;
	
	private static final class mapScore implements RowMapper<ScoreBean> {

		@Override
		public ScoreBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			ScoreBean bean = new ScoreBean();
			bean.setId(rs.getInt("id"));
			bean.setGroupCode(rs.getString("GROUP_CODE"));
			bean.setQuestionGroup(rs.getString("QUESTION_GROUP"));
			bean.setQuestionCode(rs.getString("QUESTION_CODE"));
			bean.setScore1(rs.getString("SCORE_1"));
			bean.setScore2(rs.getString("SCORE_2"));
			bean.setScore3(rs.getString("SCORE_3"));
			bean.setScore4(rs.getString("SCORE_4"));
			bean.setScore5(rs.getString("SCORE_5"));
			return bean;
		}

	}

	@Override
	public int save(ScoreBean bean) throws Exception {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO SCORE (GROUP_CODE , QUESTION_GROUP , QUESTION_CODE , SCORE_1 , SCORE_2  , SCORE_3, SCORE_4, SCORE_5 )  VALUES (?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "id" });
				pst.setString(1, bean.getGroupCode());
				pst.setString(2, bean.getQuestionGroup());
				pst.setString(3, bean.getQuestionCode());
				pst.setString(4, bean.getScore1());
				pst.setString(5, bean.getScore2());
				pst.setString(6, bean.getScore3());
				pst.setString(7, bean.getScore4());
				pst.setString(8, bean.getScore5());
				return pst;
			}
		}, keyHolder);
		int newUserId = keyHolder.getKey().intValue();
		
		return newUserId;
	}

	@Override
	public void update(ScoreBean bean) throws Exception {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" UPDATE SCORE set SCORE_1 = ?, SCORE_2 = ?, SCORE_3 = ?, SCORE_4 = ?, SCORE_5 = ? WHERE ID = ?");
		
		param.add(bean.getScore1());
		param.add(bean.getScore2());
		param.add(bean.getScore3());
		param.add(bean.getScore4());
		param.add(bean.getScore5());
		
		param.add(bean.getId());
		Object[] paramArr = param.toArray();
		
		jdbcTemplate.update(sql.toString(), paramArr);
	}

	@Override
	public ScoreBean findById(long id) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM SCORE ");
		sql.append(" WHERE ID = ? ");
		
		ScoreBean res = jdbcTemplate.queryForObject(sql.toString(), new Object[] { id }, new mapScore());
		
		return res;
	}

	@Override
	public List<ScoreBean> findAll() throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM SCORE order by ID ");
		
		List<ScoreBean> list = jdbcTemplate.query(sql.toString() , new mapScore());
		setNameList(list);
		
		return list;
	}

	@Override
	public void delete(int id) {
		String delsql = "DELETE FROM SCORE WHERE ID = "+id;
		jdbcTemplate.update(delsql);
	}
	
	String getNameByKeyCode(String group) {
		String name = "";
		
		if(StringUtils.isNotBlank(group)) {
			MasterDataBean data = masterDataDao.findGroupTypeByKeyCode(group);
			name = data.getText();
		}
		
		return name;
	}
	
	void setNameList(List<ScoreBean> list) {
		List<ScoreBean> resp = new ArrayList<ScoreBean>();
		for(ScoreBean item : list) {
			ScoreBean data = new ScoreBean();
			
			item.setGroupName(getNameByKeyCode(item.getGroupCode()));
			item.setQuestionGroupName(getNameByKeyCode(item.getQuestionGroup()));
			item.setQuestionCodeName(getNameByKeyCode(item.getQuestionCode()));
			data = item;
			
			resp.add(data);
		}
		list = resp;
	}

	@Override
	public List<ScoreBean> findByGroupAndQGroupAndQCode(String group, String qGroup, String qCode) throws Exception {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		
		sql.append(" SELECT * FROM SCORE where 1=1 and GROUP_CODE = ? and QUESTION_GROUP = ? and QUESTION_CODE = ? order by QUESTION_CODE ");
		
		param.add(group);
		param.add(qGroup);
		param.add(qCode);
		Object[] paramArr = param.toArray();
		
		List<ScoreBean> list = jdbcTemplate.query(sql.toString(), paramArr, new mapScore());
		setNameList(list);
		
		return list;
	}

}
