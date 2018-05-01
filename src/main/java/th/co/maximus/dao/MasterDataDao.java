package th.co.maximus.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import th.co.maximus.bean.MasterDataBean;
import th.co.maximus.bean.PaymentManualBean;
@Repository
public interface MasterDataDao {
	
	public List<MasterDataBean> findAllByBankCode() ;
	public List<MasterDataBean> findAllByBankName() ;
	List<MasterDataBean> findAll();
	public int insertMasterdata(MasterDataBean masterDataBean);
	public int insertMasterdataGroup(MasterDataBean masterDataBean);
	public List<MasterDataBean> findAllByServiceType();
	public List<MasterDataBean> findAllByServiceDepartment();
	public List<MasterDataBean> findAllByServiceName();
	public List<MasterDataBean> findAllByCategory();
	public List<MasterDataBean> findAllByGropType(String groupType);

}
