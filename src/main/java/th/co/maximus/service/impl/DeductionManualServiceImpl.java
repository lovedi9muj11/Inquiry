package th.co.maximus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.DeductionManualBean;
import th.co.maximus.dao.DeductionManualDao;
import th.co.maximus.service.DeductionManualService;

@Service
public class DeductionManualServiceImpl implements DeductionManualService{
	
	@Autowired DeductionManualDao deductionManualDao;

	@Override
	public void insertDeductionManual(DeductionManualBean deductionManualBean) {
		
		deductionManualDao.insert(deductionManualBean);
	}
	
	@Override
	public List<DeductionManualBean> DeductionManualAll() {
		//return jdbcTemplate.query("select * from deduction_manual", new DeductionManualJoin());
		return null;
	}
	
	/*public PaymentManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentManuaJoin());
	}*/


}
