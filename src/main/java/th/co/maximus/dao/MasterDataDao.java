package th.co.maximus.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import th.co.maximus.bean.MasterDataBean;
@Repository
public interface MasterDataDao {
	
	public List<MasterDataBean> findAllByBankCode() ;
	public List<MasterDataBean> findAllByBankName() ;

}
