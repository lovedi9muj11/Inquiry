package th.co.inquiry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.inquiry.dao.ScoreDao;
import th.co.inquiry.model.ScoreBean;

@Service
public class ScoreService {
	
	@Autowired
	private ScoreDao scoreDao;
	
	public ScoreBean findById(long id) throws Exception {
		ScoreBean resp = new ScoreBean();
		resp = scoreDao.findById(id);
		return resp;
	}
	
	public List<ScoreBean> findAll() throws Exception {
		List<ScoreBean> resp = new ArrayList<ScoreBean>();
		resp = scoreDao.findAll();
		return resp;
	}
	
	public void save(ScoreBean bean) throws Exception {
		if(bean.getId()>0) {
			bean.setId(bean.getId());
			scoreDao.update(bean);
		}else {
			scoreDao.save(bean);
		}
		
	}
	
	public void delete(int id) throws Exception {
		scoreDao.delete(id);
	}
}
