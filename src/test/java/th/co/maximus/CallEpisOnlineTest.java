package th.co.maximus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import th.co.maximus.batch.CallEpisOnline;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CallEpisOnlineTest {
	
	@Test
	public void callRest() {
		CallEpisOnline callEpisOnline = new CallEpisOnline();
		callEpisOnline.testRestFul();
	}

}
