package th.co.maximus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.TrsChequeRefManualBean;
import th.co.maximus.dao.TrsChequeRefManualDao;
import th.co.maximus.model.TrsChequerefEpisOffline;
import th.co.maximus.service.TrsChequeRefManualService;

@Service
public class TrsChequeRefManualServiceImpl implements TrsChequeRefManualService{

	@Autowired
	private TrsChequeRefManualDao trsChequeRefManualDao;

	@Override
	public void insertTrsChequeRefManual(TrsChequeRefManualBean trsChequeRefManualBean) {

	
	}
	
	@Override
	public List<TrsChequeRefManualBean> TrsChequeRefManualAll() {
		//return jdbcTemplate.query("select * from trschequeref_manual", new TrsChequeRefManualJoin());
		return null;
	}

	@Override
	public List<TrsChequerefEpisOffline> findTrsCredit(long methodTrsId) throws Exception {
		// TODO Auto-generated method stub
		return trsChequeRefManualDao.findByManualId(methodTrsId);
	}



	
	
}
