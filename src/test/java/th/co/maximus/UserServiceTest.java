package th.co.maximus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import th.co.maximus.bean.UserBean;
import th.co.maximus.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	@Autowired UserService userService;
	
	@Test
	public void login() {
		UserBean bean = userService.authenLogin("admin", "password");
		
		System.out.println("====" +bean.getUserName()); 
		
	}

}
