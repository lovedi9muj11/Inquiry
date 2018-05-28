package th.co.maximus;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import th.co.maximus.auth.model.UserDto;
import th.co.maximus.auth.repository.RoleRepository;
import th.co.maximus.auth.repository.UserRepository;
import th.co.maximus.auth.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {
	
	@Autowired  UserRepository userRepository;
	  
	@Autowired  UserService userService;
	  
	@Autowired  RoleRepository roleRepository;
	
	@Rollback
	@Test
	public void save() {
		UserDto bean = new UserDto();
		bean.setPassword("password");
		bean.setUsername("epis11");
		bean.setPasswordConfirm("password");
		bean.setRoles(roleRepository.findAll());
		userService.save(bean);
		assertThat(bean).isNotNull();
	}
	
	@Rollback
	@Test
	public void login() {
		UserDto bean = userRepository.findByUsername("admin");
		assertThat(bean).isNotNull();
	}
	
}
