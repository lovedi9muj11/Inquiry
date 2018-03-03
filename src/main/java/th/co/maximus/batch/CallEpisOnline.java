package th.co.maximus.batch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import th.co.maximus.bean.BeanClass;

public class CallEpisOnline {

	RestTemplate restTemplate;
	
	public CallEpisOnline() {
		restTemplate = new RestTemplate();
	}
	
	public void testRestFul() {
		String postUrl = "http://localhost:8080/Maximus/Test";
		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, new BeanClass(), String.class);
		System.out.println("Response for Post Request: " + postResponse.getBody());
	}
	
}
