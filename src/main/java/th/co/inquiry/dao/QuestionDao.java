package th.co.inquiry.dao;

import java.util.List;

import th.co.inquiry.model.QuestionBean;

public interface QuestionDao {
	
	QuestionBean findById(long id) throws Exception;
	
	List<QuestionBean> findByType(String type, String username) throws Exception;
	
	List<QuestionBean> findByGroupCode(String code) throws Exception;
	
	List<QuestionBean> findByType(String type) throws Exception;
	
	int findByGroupAndTypeAndScoreAndSeq(String group, String type, String scroe, String seq) throws Exception;
	
	public int save(QuestionBean bean) throws Exception;
	
	void update(QuestionBean bean) throws Exception;

	public int countUser() throws Exception;
}
