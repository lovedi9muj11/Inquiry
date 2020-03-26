package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.MapGLBean;
import th.co.maximus.constants.Constants;

@Service
public class MapGLDaoImp implements MapGLDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final class mapGL implements RowMapper<MapGLBean> {

		@Override
		public MapGLBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			MapGLBean glBean = new MapGLBean();
			glBean.setId(rs.getLong("id"));
			glBean.setGlCode(rs.getString("GL_CODE"));
			glBean.setServiceCode(rs.getString("SERVICE_CODE"));
			glBean.setProductCode(rs.getString("PRODUCT_CODE"));
			glBean.setProductName(rs.getString("PRODUCT_NAME"));
			glBean.setSubProductCode(rs.getString("SUB_PRODUCT_CODE"));
			glBean.setSubProductName(rs.getString("SUB_PRODUCT_NAME"));
			glBean.setServiceName(rs.getString("SERVICE_NAME"));
			glBean.setRevenueTypeCode(rs.getString("REVENUE_TYPE_CODE"));
			glBean.setRevenueTypeName(rs.getString("REVENUE_TYPE_NAME"));
			glBean.setSegMentCode(rs.getString("SEGMENT_CODE"));
			glBean.setSegMentName(rs.getString("SEGMENT_NAME"));
			glBean.setSource(rs.getString("SOURCE"));
			glBean.setStatus(rs.getString("STATUS"));
			glBean.setRemark(rs.getString("REMARK"));
			glBean.setRecordStatus(rs.getString("RECORD_STATUS"));
			
			return glBean;
		}

	}

	@Override
	public List<MapGLBean> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MAP_GL_SERVICE_TYPE  ");
		return jdbcTemplate.query(sql.toString() , new mapGL());
	}

	@Override
	public List<MapGLBean> findBySource(String source) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MAP_GL_SERVICE_TYPE mg  ");
		sql.append(" WHERE mg.SOURCE = '"+source+"' AND mg.STATUS = '1' GROUP BY REVENUE_TYPE_CODE");
		return jdbcTemplate.query(sql.toString() , new mapGL());
	}

	@Override
	public List<MapGLBean> findByRevenuType(String revennuId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MAP_GL_SERVICE_TYPE mg  ");
		sql.append(" WHERE mg.REVENUE_TYPE_CODE = '"+revennuId+"' ");
		sql.append(" AND mg.SOURCE = '"+Constants.MasterData.OTHER+"' ");
		return jdbcTemplate.query(sql.toString() , new mapGL());
	}
	
	@Override
	public List<MapGLBean> findByProductSource(String revennuId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MAP_GL_SERVICE_TYPE mg  ");
		sql.append(" WHERE mg.PRODUCT_CODE = '"+revennuId+"' ");
		sql.append(" AND mg.SOURCE = '"+Constants.MasterData.OTHER+"' ");
		return jdbcTemplate.query(sql.toString() , new mapGL());
	}
	
	@Override
	public List<MapGLBean> findBySourceOther() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MAP_GL_SERVICE_TYPE mg  ");
		sql.append(" WHERE mg.SOURCE = '"+Constants.MasterData.OTHER+"' AND mg.STATUS = '1' ");
		return jdbcTemplate.query(sql.toString() , new mapGL());
	}

	@Override
	public List<MapGLBean> findBySourceOtherProdCode(String prodCode) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MAP_GL_SERVICE_TYPE mg  ");
		sql.append(" WHERE mg.SOURCE = '"+Constants.MasterData.OTHER+"' AND mg.STATUS = '1' ");
		sql.append(" AND mg.PRODUCT_CODE =  '"+prodCode+"'");
		return jdbcTemplate.query(sql.toString() , new mapGL());
	}

}
