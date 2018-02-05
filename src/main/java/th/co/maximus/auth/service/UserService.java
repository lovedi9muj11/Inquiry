package th.co.maximus.auth.service;

import java.util.List;

import th.co.maximus.auth.model.User;

public interface UserService {
	
    void save(User user);

    User findByUsername(String username);
    
    List<User> findAll();
    
}
