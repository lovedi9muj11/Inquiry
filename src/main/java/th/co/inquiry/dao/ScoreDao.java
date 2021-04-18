package th.co.inquiry.dao;

import java.util.List;

import th.co.inquiry.model.ScoreBean;

public interface ScoreDao {

	public int save(ScoreBean bean) throws Exception;
	
	void update(ScoreBean bean) throws Exception;
	
	ScoreBean findById(long id) throws Exception;
	
	List<ScoreBean> findAll() throws Exception;
	
	List<ScoreBean> findByGroupAndQGroupAndQCode(String group, String qGroup, String qCode) throws Exception;
	
	public void delete(int id);
}
