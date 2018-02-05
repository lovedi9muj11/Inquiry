package th.co.maximus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import th.co.maximus.auth.model.User;
import th.co.maximus.auth.repository.RoleRepository;
import th.co.maximus.auth.repository.UserRepository;
import th.co.maximus.auth.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired private UserRepository userRepository;
	  
	@Autowired private UserService userService;
	  
	@Autowired private RoleRepository roleRepository;
	
	@Ignore
	@Test
	public void login() {
		User bean = userRepository.findByUsername("admin");
		assertThat(bean).isNotNull();
	}
	
	@Test
	public void save() {
		User bean = new User();
		bean.setPassword("password");
		bean.setUsername("Epis11");
		bean.setPasswordConfirm("password");
		bean.setRoles(new HashSet<>(roleRepository.findAll()));
		userService.save(bean);
		assertThat(bean).isNotNull();
	}

}
