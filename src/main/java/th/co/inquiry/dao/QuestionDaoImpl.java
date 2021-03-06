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

import th.co.inquiry.model.QuestionBean;

@Service
public class QuestionDaoImpl implements QuestionDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final class questionData implements RowMapper<QuestionBean> {

		@Override
		public QuestionBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			QuestionBean bean = new QuestionBean();
			bean.setId(rs.getInt("ID"));
			bean.setGroupCode(rs.getString("GROUP_CODE"));
			bean.setSeqNo(rs.getString("SEQ_NO"));
			bean.setScore(rs.getString("SCORE"));
			bean.setType(rs.getString("TYPE"));
			return bean;
		}

	}
	
	private static final class questionDataDis implements RowMapper<QuestionBean> {
		
		@Override
		public QuestionBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			QuestionBean bean = new QuestionBean();
			bean.setUserId(rs.getString("CREATE_BY"));
			return bean;
		}
		
	}

	@Override
	public QuestionBean findById(long id) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM QUESTION ");
		sql.append(" WHERE ID = ? ");
		
		QuestionBean res = jdbcTemplate.queryForObject(sql.toString(), new Object[] { id }, new questionData());
		
		return res;
	}

	@Override
	public List<QuestionBean> findByType(String type, String username) throws Exception {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		
		sql.append("SELECT * FROM QUESTION ");
		sql.append(" WHERE TYPE = ? and CREATE_BY = ? ");
		
		param.add(type);
		param.add(username);
		Object[] paramArr = param.toArray();
		
		List<QuestionBean> res = jdbcTemplate.query(sql.toString(), paramArr, new questionData());
		return res;
	}

	@Override
	public List<QuestionBean> findByGroupCode(String code) throws Exception {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		
		sql.append("SELECT * FROM QUESTION ");
		sql.append(" WHERE GROUP_CODE = ? ");
		
		param.add(code);
		Object[] paramArr = param.toArray();
		
		List<QuestionBean> res = jdbcTemplate.query(sql.toString(), paramArr, new questionData());
		return res;
	}

	@Override
	public int save(QuestionBean bean) throws Exception {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO QUESTION (GROUP_CODE , SEQ_NO , SCORE , TYPE , CREATE_BY  , UPDATE_BY, QUESTION_CODE )  VALUES (?,?,?,?,?,?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "id" });
				pst.setString(1, bean.getGroupCode());
				pst.setString(2, bean.getSeqNo());
				pst.setString(3, bean.getScore());
				pst.setString(4, bean.getType());
				pst.setString(5, bean.getUserId());
				pst.setString(6, bean.getUserId());
				pst.setString(7, bean.getQuestionCode());
				return pst;
			}
		}, keyHolder);
		int newUserId = keyHolder.getKey().intValue();
		
		return newUserId;
	}

	@Override
	public void update(QuestionBean bean) throws Exception {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" UPDATE QUESTION set GROUP_CODE = ?, SEQ_NO = ?, SCORE = ?, TYPE = ?, QUESTION_CODE = ? WHERE ID = ?");
		
		param.add(bean.getGroupCode());
		param.add(bean.getSeqNo());
		param.add(bean.getScore());
		param.add(bean.getType());
		param.add(bean.getQuestionCode());
		
		param.add(bean.getId());
		Object[] paramArr = param.toArray();
		
		jdbcTemplate.update(sql.toString(), paramArr);
	}

	@Override
	public List<QuestionBean> findByType(String type) throws Exception {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		
		sql.append("SELECT * FROM QUESTION ");
		sql.append(" WHERE TYPE = ? ");
		
		param.add(type);
		Object[] paramArr = param.toArray();
		
		List<QuestionBean> res = jdbcTemplate.query(sql.toString(), paramArr, new questionData());
		return res;
	}

	@Override
	public int findByGroupAndTypeAndScoreAndSeq(String group, String type, String scroe, String seq) throws Exception {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		
		sql.append(" SELECT * FROM QUESTION ");
		sql.append(" WHERE GROUP_CODE = ? ");
		sql.append(" And TYPE = ? ");
		sql.append(" And SCORE = ? ");
		sql.append(" And SEQ_NO = ? ");
		
		param.add(group);
		param.add(type);
		param.add(scroe);
		param.add(seq);
		Object[] paramArr = param.toArray();
		
		List<QuestionBean> res = jdbcTemplate.query(sql.toString(), paramArr, new questionData());
		
		return res.size();
	}

	@Override
	public int countUser() throws Exception {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT DISTINCT CREATE_BY FROM QUESTION ");
		
		List<QuestionBean> res = jdbcTemplate.query(sql.toString(), new questionDataDis());
		
		return res.size();
	}

}
