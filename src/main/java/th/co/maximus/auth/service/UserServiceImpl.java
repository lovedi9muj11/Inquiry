package th.co.maximus.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.UserDto;
import th.co.maximus.auth.repository.RoleRepository;
import th.co.maximus.auth.repository.UserRepository;
import th.co.maximus.bean.UserBean;
import th.co.maximus.service.MasOfficerService;

@SuppressWarnings("deprecation")
@Service
public class UserServiceImpl implements UserService {
	
    @Autowired private UserRepository userRepository;
    
    @Autowired private RoleRepository roleRepository;
    
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
	MasOfficerService masOfficerService;
    

    @Override
    public void save(UserDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findAll());
        userRepository.save(user);
    }

    @Override
    public UserDto findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public List<UserDto> findAll() {
		return userRepository.findAll();
	}

	@Override
	public String saveConfirmPassword(UserBean user, String username) {
//		MessageDigest messageDigest;
//			messageDigest = MessageDigest.getInstance("MD5");
//			messageDigest.update(user.getPassword().getBytes(),0, user.getPassword().length());  
//			String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);  
//			if (hashedPass.length() < 32) {
//			   hashedPass = "0" + hashedPass; 
//			}
		PasswordEncoder encoder = new Md5PasswordEncoder();
	    String hashedPass = encoder.encodePassword(user.getPassword(), null);
	    insertUpdatePassword(hashedPass, username);
		return null;
	}

	@Override
	public boolean checkPassword(String password, String username) {
		UserDto user = userRepository.findByUsername(username);
		boolean res = true;
		if(null != user) {
			PasswordEncoder encoder = new Md5PasswordEncoder();
		    String hashedPass = encoder.encodePassword(password, null);
			res = hashedPass.equals(user.getPassword());
//			PasswordEncoder encoder = new Md5PasswordEncoder();
//		    String hashedPass = encoder.encodePassword(password, null);
//			if(!hashedPass.equals(user.getPassword())) {
//			}
		}
		return res;
	}
	
	void insertUpdatePassword(String password, String username) {
		masOfficerService.updatePassword(password, username);
	}
}
