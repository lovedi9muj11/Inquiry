package th.co.maximus.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.User;
import th.co.maximus.auth.repository.RoleRepository;
import th.co.maximus.auth.repository.UserRepository;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired private UserRepository userRepository;
    
    @Autowired private RoleRepository roleRepository;
    
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
