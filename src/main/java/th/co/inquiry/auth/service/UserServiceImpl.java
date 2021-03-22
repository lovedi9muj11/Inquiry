package th.co.inquiry.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import th.co.inquiry.auth.model.Role;
import th.co.inquiry.auth.model.UserDto;
import th.co.inquiry.auth.repository.RoleRepository;
import th.co.inquiry.auth.repository.UserRepository;
import th.co.inquiry.dao.MasOfficerDao;
import th.co.inquiry.service.MasOfficerService;
import th.co.inquiryx.bean.DropDownBean;
import th.co.inquiryx.bean.UserBean;

@SuppressWarnings("deprecation")
@Service
public class UserServiceImpl implements UserService {
	
    @Autowired private UserRepository userRepository;
    
    @Autowired private RoleRepository roleRepository;
    
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
	MasOfficerService masOfficerService;
    
    @Autowired
	MasOfficerDao masOfficerDao;
    
    @Autowired private UserService userService;

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
		}
		return res;
	}
	
	void insertUpdatePassword(String password, String username) {
		masOfficerService.updatePassword(password, username);
	}

	@Override
	public void save(UserBean user, String username) {
		if(null!=user.getId()) {
			UserDto res = userService.findByUsername(user.getUserName());
			user.setId(res.getId());
			user.setPassword(res.getPassword());
			
			masOfficerDao.updatetUserService(user);
		}else {
			PasswordEncoder encoder = new Md5PasswordEncoder();
		    String hashedPass = encoder.encodePassword(user.getPassword(), null);
		    user.setPassword(hashedPass);
		    
		    int idUser = masOfficerDao.insertUserService(user);
		    if(idUser>0)masOfficerDao.insertUserRole(idUser, user.getIdRole());
		}
	}

	@Override
	public List<DropDownBean> getRoles() {
		List<DropDownBean> res = new ArrayList<DropDownBean>();
		List<Role> roles = roleRepository.findAll();
		for(Role data : roles) {
			DropDownBean bean = new DropDownBean();
			bean.setKey(data.getId().toString());
			bean.setValue(data.getName());
			
			res.add(bean);
		}
		return res;
	}

	@Override
	public void delete(UserBean user, String username) {
		userRepository.delete(user.getId());
//		int id = masOfficerDao.findUserRole(user.getId());
//		roleRepository.delete(Long.valueOf(id));
	}

	@Override
	public List<UserBean> fineById(UserBean user) {
		// TODO Auto-generated method stub
		return null;
	}
}
