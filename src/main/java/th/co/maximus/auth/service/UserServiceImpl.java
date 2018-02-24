package th.co.maximus.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.UserDto;
import th.co.maximus.auth.repository.RoleRepository;
import th.co.maximus.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired private UserRepository userRepository;
    
    @Autowired private RoleRepository roleRepository;
    
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

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
}
