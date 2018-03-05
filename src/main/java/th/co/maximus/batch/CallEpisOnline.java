package th.co.maximus.batch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import th.co.maximus.bean.BeanClass;

@ConfigurationProperties
public class CallEpisOnline {
	
	@Value("${url.online}")
	private String url;

	RestTemplate restTemplate;
	
	public CallEpisOnline() {
		restTemplate = new RestTemplate();
	}
	
	public void testRestFul(){
		try {
			String postUrl = "http://localhost:8080".concat("/Maximus/Test");
			ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, new BeanClass(), String.class);
			System.out.println("Response for Post Request: " + postResponse.getBody());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
