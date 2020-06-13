package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.CasualCustomerBean;

public interface CasualCustomerService {
	List<CasualCustomerBean> findByNameTaxId(CasualCustomerBean creteria);
}
