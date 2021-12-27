package client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import in.codertechnologies.contactapp.model.UserEntity;

public class UserRestClient {

	public static void main(String[] args) {
		
		String BASE_URI = "http://localhost:8081/ContactWebApplication";
		RestTemplate restTemplate=new RestTemplate();
		String response=restTemplate.getForObject(BASE_URI+"/welcome", String.class);
		System.out.println("response=="+response);
		
		
		UserEntity user=restTemplate.getForObject(BASE_URI+"/user", UserEntity.class);
		System.out.println("user is=="+user);
		
		//for getting json response
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-type", "application/json");
		HttpEntity<UserEntity> reqestEntity=new HttpEntity<UserEntity>(headers);
		//ResponseEntity<User> responEntity=restTemplate.exchange(BASE_URI+"/user", HttpMethod.GET, reqestEntity, User.class);//converted json to user formT
		//ResponseEntity<String> responEntity=restTemplate.exchange(BASE_URI+"/user", HttpMethod.GET, reqestEntity,String.class);//in json format
		ResponseEntity<String> responEntity=restTemplate.exchange(BASE_URI+"/user", HttpMethod.GET, reqestEntity,String.class);//in xml format
		System.out.println("user is=="+user);
		System.out.println(responEntity.getBody());
		
		if(responEntity.getStatusCode().equals(HttpStatus.OK)) {
			
		}else {
			System.out.println("There is some error.....");
		}
	}
}
