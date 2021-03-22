package th.co.inquiry.auth.service;

import java.util.List;

import th.co.inquiry.auth.model.UserDto;
import th.co.inquiryx.bean.DropDownBean;
import th.co.inquiryx.bean.UserBean;

public interface UserService {
	
    void save(UserDto user);

    UserDto findByUsername(String username);
    
    List<UserDto> findAll();
    
    String saveConfirmPassword(UserBean user, String username);
    
    boolean checkPassword(String password, String username);
    
    void save(UserBean user, String username);
    
    void delete(UserBean user, String username);
    
    List<UserBean> fineById(UserBean user);
    
    List<DropDownBean> getRoles();
    
}
