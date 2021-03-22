package th.co.inquiry.service;

import org.springframework.stereotype.Service;

@Service
public interface MasOfficerService {
	
	void updatePassword(String password, String username);

}
