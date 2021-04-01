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

	public List<QuestionBean> findByType(String type, String username) throws Exception {
		List<QuestionBean> resp = new ArrayList<QuestionBean>();
		resp = questionDao.findByType(type, username);
		return resp;
	}

	public List<QuestionBean> findByGroupCode(String code) throws Exception {
		List<QuestionBean> resp = new ArrayList<QuestionBean>();
		resp = questionDao.findByGroupCode(code);
		return resp;
	}
	
	public void save(QuestionBean bean) throws Exception {
		for(int i=0; i<bean.getQuestList().size(); i++) {
			QuestionBean dto = new QuestionBean();
			dto.setUserId(bean.getUserId());
			dto.setGroupCode(null);
			dto.setScore(bean.getQuestList().get(i).getScore());
			dto.setSeqNo(bean.getQuestList().get(i).getSeqNo());
			dto.setType(bean.getType());
			
			if(bean.getQuestList().get(i).getId()>0) {
				dto.setId(bean.getQuestList().get(i).getId());
				questionDao.update(dto);
			}else {
				questionDao.save(dto);
			}
		}
		
	}

}
