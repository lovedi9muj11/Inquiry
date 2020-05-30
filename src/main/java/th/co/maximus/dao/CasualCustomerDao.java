package th.co.maximus.dao;

import th.co.maximus.bean.CasualCustomerBean;

public interface CasualCustomerDao {
	public void insert(CasualCustomerBean bean) throws Exception;
	
	public void update(CasualCustomerBean bean) throws Exception;
	
	public CasualCustomerBean findByTaxId(String taxId) throws Exception;
}
