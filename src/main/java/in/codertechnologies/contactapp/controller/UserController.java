package in.codertechnologies.contactapp.controller;


import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.codertechnologies.contactapp.model.Contact;
import in.codertechnologies.contactapp.model.UserEntity;
import in.codertechnologies.contactapp.service.ContactService;
import in.codertechnologies.contactapp.service.UserService;


@Controller
public class UserController {
	
	@Autowired	
	UserService uService;
	
	@Autowired
	ContactService contactService;
	
	
	
	
	@Validated
	public @interface registrationValidation{
		
		
	}
	
public @interface loginValidation{
		
		
	}
	
	@RequestMapping("/")
	public String home() {
		System.out.println("inside home()");
		
		 return "user/home"; 
	}
	
	

	
	@RequestMapping("/viewUser")    
	public String viewUser(Model m){
		System.out.println("inside viewemp()----");
        List<UserEntity> list=uService.findAll();
        for(UserEntity u:list) {

			System.out.println("User Id="+u.getUserId()+", Name="+u.getProfileName()+", User Name="+u.getUsername()+", Password="+u.getPassword()+", Active="+u.isActive());
		}
	
        m.addAttribute("list",list);  
        return "user/viewUser";    
    }
	
	//@RequestMapping(value = "/login", method = RequestMethod.GET)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error) {
		System.out.println("inside login get--");
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        return "user/login";
    }
	
	
	//@RequestMapping(value = "/login" , method = RequestMethod.POST)
	@PostMapping("/login")
	public String performLogin(@Validated  @ModelAttribute("user") UserEntity user,Errors errors ,Model m)
	{	  
		
		System.out.println("------------");
		System.out.println(errors.hasErrors());
		System.out.println("------------");
		if(errors.hasErrors())
			return "user/login";
		
//		try 
//		{	
		
			UserEntity u1=new UserEntity();
			
			u1=uService.performLogin(user);
			//m.addAttribute("user",user);
			
			List<Contact> contactlist=contactService.findAllUserContact(u1.getUserId());
			List<UserEntity> userList=uService.findAll();
			if(u1.getUsername().equals("admin") && u1.getPassword().equals("admin"))
				{
				for(UserEntity u:userList) {

					System.out.println("User Id="+u.getUserId()+", Name="+u.getProfileName()+", User Name="+u.getUsername()+", Password="+u.getPassword()+", Active="+u.isActive());
				}
				m.addAttribute("user", new UserEntity());
				m.addAttribute("profileName", u1.getProfileName());
	        	m.addAttribute("userId",u1.getUserId());
		        m.addAttribute("list",userList);	
				
			return "user/viewUser";
			}
			else
			{
	        for(Contact contact:contactlist) {

				System.out.println("contact Id="+contact.getContactId()+",First Name="+contact.getFirstName()+", Last Name="+contact.getLastname()+", email="+contact.getEmail()+", mobile="+contact.getMobile());
			}
	        
				m.addAttribute("contact",new Contact());
	        	m.addAttribute("list",contactlist);  
	        	m.addAttribute("profileName", u1.getProfileName());
	        	m.addAttribute("userId",u1.getUserId());
				return "userContact/viewContact";
			}
		}
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
		//m.addAttribute("errorMsg", "Invalid Credentails");
		//return "login";
	//}
	
	//@RequestMapping(value = "/register", method = RequestMethod.GET)
		@GetMapping("/register")
		public String showRegistration(Model m) {
			System.out.println("inside showRegistration()");
			  m.addAttribute("user", new UserEntity());
			 return "user/registration"; 
		}
//	@RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
//	public String doregistration(@RequestParam("username") String name,@RequestParam("profileName") String profileName,@RequestParam("password") String pass,Model m) {
//		System.out.println("inside registration");
//		
//		User newUser = new User();
//		newUser.setProfileName(profileName);
//		newUser.setUsername(name);
//		newUser.setPassword(pass);
//		uService.registerUser(newUser);
//		
//		Contact newContact=new Contact();
//		newContact.setFirstName("Manu");
//		newContact.setLastname("Sathe");
//		newContact.setEmail("manu@gmail.com");
//		newContact.setMobile("8433609822");
//		newContact.setUserId(8);
//				
//				m.addAttribute("message", "Username or Password is wrong!!");
//				 m.addAttribute("register", new User());
//				 m.addAttribute("message", "You have successfully registered on Contact Web Application");
//					return "registration"; 
//			
//			
//		  
//		 
//	}
	
	//@RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
	@PostMapping("/register")
	public String doregistration(@Valid @ModelAttribute("user") UserEntity user,Errors errors,Model m) {
		System.out.println("inside registration");
		
		
		System.out.println("------------");
		System.out.println(errors.hasErrors());
		System.out.println("------------");
		if(errors.hasErrors())
			return "user/registration";
	
		uService.registerUser(user);
		m.addAttribute("user", user);
		m.addAttribute("message", "You have successfully registered on Contact Web Application,please login to your account");
		return "user/registration"; 
			
			
		  
		 
	}
	
	@GetMapping("/addUser")
	public String addUser( @RequestParam(name = "userId") String userId,Model m) {
		System.out.println("inside addUser()----"+userId);
		m.addAttribute("userId",userId);
		UserEntity u1=uService.findUserByUserId(Integer.parseInt(userId));
		m.addAttribute("profileName",u1.getProfileName());
		m.addAttribute("user", new UserEntity());
		 return "user/addUser"; 
	}
	
	
	@PostMapping("/addUser")
	public String saveUser(@Valid   @ModelAttribute("user") UserEntity user,Errors errors ,Model m) {
		System.out.println("inside adduser()----");
		
		System.out.println("------------");
		System.out.println(errors.hasErrors());
		System.out.println("------------");
		if(errors.hasErrors())
			return "user/addUser";
		System.out.println("userId==="+user.getUserId());
		uService.registerUser(user);
		List<UserEntity> list=uService.findAll();
        for(UserEntity u:list) {

			System.out.println("User Id="+u.getUserId()+", Name="+u.getProfileName()+", User Name="+u.getUsername()+", Password="+u.getPassword()+", Active="+u.isActive());
		}
        m.addAttribute("profileName",user.getProfileName());
        m.addAttribute("user",new UserEntity());
        m.addAttribute("list",list);  
        return "user/viewUser";    
		
	}
	

	@GetMapping("/populateUser")
	public String updateContact( @RequestParam(name = "module") String module, @RequestParam(name = "userId") String userId,Model m) {
		
		System.out.println("inside user()----"+userId);
		UserEntity user=uService.findUserByUserId(Integer.parseInt(userId));
		m.addAttribute("userId",user.getUserId());
		m.addAttribute("profileName",user.getProfileName());
		m.addAttribute("user", user);
		if(module.equals("1"))
		 return "user/editUser"; 
		else
			return "user/deleteUser"; 
	}
	
	@PostMapping("/editUser")
	public String updateContact(@Valid   @ModelAttribute("user") UserEntity user,Errors errors ,Model m) {
		System.out.println("inside edituser()----");
		System.out.println("username==="+user.getUsername());
		System.out.println("------------");
		System.out.println(errors.hasErrors());
		System.out.println("------------");
		if(errors.hasErrors())
			return "userContact/editContact";
		int userId=user.getUserId();
		uService.updateProfile(userId, user);
		System.out.println("user id=="+userId);
		List<UserEntity> list=uService.findAll();
        for(UserEntity u:list) {

			System.out.println("User Id="+u.getUserId()+", Name="+u.getProfileName()+", User Name="+u.getUsername()+", Password="+u.getPassword()+", Active="+u.isActive());
		}
		m.addAttribute("profileName",user.getProfileName());
		m.addAttribute("user",new UserEntity());
        m.addAttribute("list",list);  
		
		 return "user/viewUser";
	}
	
	@PostMapping("/deleteUser")
	public String deleteUser(@Valid   @ModelAttribute("user") UserEntity user,Errors errors ,Model m) {
		System.out.println("inside edituser()----");
		System.out.println("username==="+user.getUsername());
		System.out.println("------------");
		System.out.println(errors.hasErrors());
		System.out.println("------------");
		if(errors.hasErrors())
			return "userContact/editContact";
		int userId=user.getUserId();
		uService.deleteUserById(userId);
		System.out.println("user id=="+userId);
		List<UserEntity> list=uService.findAll();
        for(UserEntity u:list) {

			System.out.println("User Id="+u.getUserId()+", Name="+u.getProfileName()+", User Name="+u.getUsername()+", Password="+u.getPassword()+", Active="+u.isActive());
		}
		m.addAttribute("profileName",user.getProfileName());
		m.addAttribute("user",new UserEntity());
        m.addAttribute("list",list);  
		
		 return "user/viewUser";
	}

//
//	@GetMapping("/userPage")
//	public String userPage(Model m) {
//		System.out.println("inside displayuserpage()");
//		
//		m.addAttribute("user", new User());
//		 return "user/userPage"; 
//	}
	
//	@PostMapping("/userPage")
//	public String userPage(@ModelAttribute("user") UserEntity user,Model m)
//	{	   
//		
//		
//			int userId=user.getUserId();
//			System.out.println("userId--"+userId);
//			
//			return "userContact/viewContact";
//		}
//	
	
}
