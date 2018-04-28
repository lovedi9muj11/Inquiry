package th.co.maximus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.GroupTypeDropdown;
import th.co.maximus.bean.MasterDataBean;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;
@Service
public interface MasterDataService {
	public List<MasterDataBean> findAllByBankCode() ;
	public List<MasterDataBean> findAllByBankName() ;
	List<GroupTypeDropdown> findAll();
	public int insert(MasterDataBean masterDataBean);
	public int insertGroup(MasterDataBean masterDataBean);
	public List<MasterDataBean> findAllByServiceType();
	public List<MasterDataBean> findAllByServiceDepartment();
	public List<MasterDataBean> findAllByServiceName();
	public List<MasterDataBean> findAllByCategory();
	
}
