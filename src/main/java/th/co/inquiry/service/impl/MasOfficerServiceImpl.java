package th.co.inquiry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.inquiry.dao.MasOfficerDao;
import th.co.inquiry.service.MasOfficerService;

@Service
public class MasOfficerServiceImpl implements MasOfficerService{
	
	@Autowired
	MasOfficerDao masOfficerDao;

	@Override
	public void updatePassword(String password, String username) {
		try {
			masOfficerDao.updatePassword(password, username);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
