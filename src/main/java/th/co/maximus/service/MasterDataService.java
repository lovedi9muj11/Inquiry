package th.co.maximus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import th.co.maximus.bean.MasterDataBean;
@Service
public interface MasterDataService {
	public List<MasterDataBean> findAllByBankCode() ;
	public List<MasterDataBean> findAllByBankName() ;
}
