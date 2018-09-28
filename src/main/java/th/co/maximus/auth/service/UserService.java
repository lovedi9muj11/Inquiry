package th.co.maximus.auth.service;

import java.util.List;

import th.co.maximus.auth.model.UserDto;
import th.co.maximus.bean.UserBean;

public interface UserService {
	
    void save(UserDto user);

    UserDto findByUsername(String username);
    
    List<UserDto> findAll();
    
    String saveConfirmPassword(UserBean user, String username);
    
    boolean checkPassword(String password, String username);
    
}
