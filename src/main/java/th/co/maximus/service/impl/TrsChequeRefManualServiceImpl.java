package th.co.maximus.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import th.co.maximus.bean.TrsChequeRefManualBean;
import th.co.maximus.service.TrsChequeRefManualService;

@Service
public class TrsChequeRefManualServiceImpl implements TrsChequeRefManualService{


	@Override
	public void insertTrsChequeRefManual(TrsChequeRefManualBean trsChequeRefManualBean) {

	
	}
	
	@Override
	public List<TrsChequeRefManualBean> TrsChequeRefManualAll() {
		//return jdbcTemplate.query("select * from trschequeref_manual", new TrsChequeRefManualJoin());
		return null;
	}
	

	
	
}
