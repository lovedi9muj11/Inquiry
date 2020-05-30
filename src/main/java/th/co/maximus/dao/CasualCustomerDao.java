package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.CasualCustomerBean;

public interface CasualCustomerDao {
	public void insert(CasualCustomerBean bean) throws Exception;
	
	public void update(CasualCustomerBean bean) throws Exception;
	
	public CasualCustomerBean findByTaxId(String taxId) throws Exception;
	
	public List<CasualCustomerBean> findByTaxIdNName(String taxId, String name) throws Exception;
}
