package in.codertechnologies.contactapp.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.codertechnologies.contactapp.model.UserEntity;

@RestController //when we add restcontoller,then we do not need to write responsebody on the method
public class UserRestController {
	

	//REST WEBSERVICES
	@GetMapping("/welcome")
	//@ResponseBody
	public String hello() {
		System.out.println("inside Welcome().......");
		return "Welcome";
	}
	

	@GetMapping("/admin")
	public String admin()
	{
		System.out.println("In admin()............");
		return "Admin Section";
	}
	
	//get a resource
	@GetMapping("/user")
	//@ResponseBody
	public UserEntity helloUser() {
		System.out.println("inside helloUser method.......");
		UserEntity u1=new UserEntity();
		u1.setProfileName("Komal K");
		u1.setUsername("komal");
		return u1;
	}
	
	//create a resource
	@PostMapping("/user")
	//@ResponseBody
	public ResponseEntity<UserEntity> createUser( @RequestBody UserEntity newUser) {
		System.out.println("inside createUser method.......");
		ResponseEntity<UserEntity> responseEntity=ResponseEntity.status(HttpStatus.CREATED).body(newUser);
		return responseEntity;
	}
	
	
	//update
	//@PutMapping

	//delete
	//@DeleteMapping

}
