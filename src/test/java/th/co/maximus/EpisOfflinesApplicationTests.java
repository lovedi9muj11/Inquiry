package th.co.maximus;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import th.co.maximus.bean.UserBean;
import th.co.maximus.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EpisOfflinesApplicationTests {
	
	@Autowired UserService userService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void selectAll() {
		List<UserBean> list = new ArrayList<UserBean>();
		list = userService.selectAll();
		assertThat(list).isNotNull();
	}

}
