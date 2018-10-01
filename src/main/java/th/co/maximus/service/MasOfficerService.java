package th.co.maximus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import th.co.maximus.bean.UserBean;

@Service
public interface MasOfficerService {
	
	String insertMasOfficerUser(List<UserBean> userBeanList);
	
	void updatePassword(String password, String username);

}
