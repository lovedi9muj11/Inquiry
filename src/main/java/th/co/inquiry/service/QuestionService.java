package th.co.inquiry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.inquiry.dao.QuestionDao;
import th.co.inquiry.model.QuestionBean;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionDao questionDao;
	
	public QuestionBean findById(long id) throws Exception {
		QuestionBean resp = new QuestionBean();
		resp = questionDao.findById(id);
		return resp;
	}

	public List<QuestionBean> findByType(String type) throws Exception {
		List<QuestionBean> resp = new ArrayList<QuestionBean>();
		resp = questionDao.findByType(type);
		return resp;
	}

	public List<QuestionBean> findByGroupCode(String code) throws Exception {
		List<QuestionBean> resp = new ArrayList<QuestionBean>();
		resp = questionDao.findByType(code);
		return resp;
	}
	
	public void save(QuestionBean bean) throws Exception {
		if(bean.getId()>0) {
			questionDao.update(bean);
		}else {
			questionDao.save(bean);
		}
		
	}

}
