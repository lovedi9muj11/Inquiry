package th.co.maximus.auth.service;

import java.util.List;

import th.co.maximus.auth.model.UserDto;

public interface UserService {
	
    void save(UserDto user);

    UserDto findByUsername(String username);
    
    List<UserDto> findAll();
    
}
