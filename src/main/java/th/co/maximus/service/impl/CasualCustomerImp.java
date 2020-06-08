package th.co.maximus.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.CasualCustomerBean;
import th.co.maximus.dao.CasualCustomerDao;
import th.co.maximus.service.CasualCustomerService;

@Service
public class CasualCustomerImp implements CasualCustomerService{
	
	@Autowired CasualCustomerDao casualCustomerDao;

	@Override
	public List<CasualCustomerBean> findByNameTaxId(CasualCustomerBean creteria) {
		try {
			if(StringUtils.isNotBlank(creteria.getTaxId()) || StringUtils.isNotBlank(creteria.getName())) {
				return casualCustomerDao.findByTaxIdNName(creteria.getTaxId(), creteria.getName());
			}else {
				return casualCustomerDao.findAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
