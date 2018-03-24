package th.co.maximus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.MasterDataBean;
import th.co.maximus.dao.MasterDataDao;
import th.co.maximus.service.MasterDataService;

@Service
public class MasterDataServiceImpl implements MasterDataService{
	
	@Autowired
	MasterDataDao masterDataDao;

	@Override
	public List<MasterDataBean> findAllByBankCode() {
		List<MasterDataBean> masterDataList = masterDataDao.findAllByBankCode();
		
		return masterDataList;
	}

	@Override
	public List<MasterDataBean> findAllByBankName() {
		List<MasterDataBean> masterDataList = masterDataDao.findAllByBankName();
		return masterDataList;
	}

}
