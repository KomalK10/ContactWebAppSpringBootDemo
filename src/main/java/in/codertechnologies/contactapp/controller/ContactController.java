package in.codertechnologies.contactapp.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import in.codertechnologies.contactapp.model.Contact;
import in.codertechnologies.contactapp.model.UserEntity;
import in.codertechnologies.contactapp.service.ContactService;
import in.codertechnologies.contactapp.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	
	@Autowired	
	UserService uService;
	
	@Validated
	public @interface addContactValidation{
		
		
	}
	
	
	@GetMapping("/userContact")
	public String userContact( @RequestParam(name = "userId") String userId,Model m) {
		System.out.println("inside usercontact()----"+userId);
		m.addAttribute("userId",userId);
		UserEntity u1=uService.findUserByUserId(Integer.parseInt(userId));
		m.addAttribute("profileName",u1.getProfileName());
		m.addAttribute("contact", new Contact());
		 return "userContact/addContact"; 
	}
	
	@PostMapping("/userContact")
	public String addContact(@Valid   @ModelAttribute("contact") Contact contact,Errors errors ,Model m) {
		System.out.println("inside addcontact()----");
		
		System.out.println("------------");
		System.out.println(errors.hasErrors());
		System.out.println("------------");
		if(errors.hasErrors())
			return "userContact/addContact";
		System.out.println("userId==="+contact.getUserId());
		contactService.saveContact(contact);
		List<Contact> contactlist=contactService.findAllUserContact(contact.getUserId());
		UserEntity user=uService.findUserByUserId(contact.getUserId());
		m.addAttribute("profileName",user.getProfileName());
		m.addAttribute("contact",new Contact());
        m.addAttribute("list",contactlist);  
		
		 return "userContact/viewContact"; 
	}
	
	@GetMapping("/populateContact")
	public String updateContact( @RequestParam(name = "module") String module, @RequestParam(name = "contactId") String contactId,Model m) {
		
		System.out.println("inside usercontact()----"+contactId);
		Contact contact=contactService.findeContactById(Integer.parseInt(contactId));
		System.out.println("contact Id="+contact.getContactId()+",First Name="+contact.getFirstName()+", Last Name="+contact.getLastname()+", email="+contact.getEmail()+", mobile="+contact.getMobile());
		UserEntity user=uService.findUserByUserId(contact.getUserId());
		m.addAttribute("userId",user.getUserId());
		m.addAttribute("profileName",user.getProfileName());
		m.addAttribute("contact", contact);
		if(module.equals("1"))
		 return "userContact/editContact"; 
		else
			return "userContact/deleteContact"; 
	}
	
	@PostMapping("/editContact")
	public String updateContact(@Valid   @ModelAttribute("contact") Contact contact,Errors errors ,Model m) {
		System.out.println("inside editcontact()----");
		System.out.println("contactname==="+contact.getFirstName());
		System.out.println("------------");
		System.out.println(errors.hasErrors());
		System.out.println("------------");
		if(errors.hasErrors())
			return "userContact/editContact";
		int userId=contact.getUserId();
		
		contactService.updateContact(contact.getContactId(), contact);
		System.out.println("user id=="+userId);
		List<Contact> contactlist=contactService.findAllUserContact(contact.getUserId());
		UserEntity user=uService.findUserByUserId(contact.getUserId());
		m.addAttribute("profileName",user.getProfileName());
		m.addAttribute("contact",new Contact());
        m.addAttribute("list",contactlist);  
		
		 return "userContact/viewContact";
	}
	
	
	@RequestMapping("/viewContact")    
	public String viewUser( @RequestParam(name = "userId") int userId,Model m){
		System.out.println("inside viewContact()----");
		List<Contact> contactlist=contactService.findAllUserContact(userId);
        for(Contact contact:contactlist) {

			System.out.println("contact Id="+contact.getContactId()+",First Name="+contact.getFirstName()+", Last Name="+contact.getLastname()+", email="+contact.getEmail()+", mobile="+contact.getMobile());
		}
        m.addAttribute("contact",new Contact());
        UserEntity user=uService.findUserByUserId(userId);
        m.addAttribute("userId",user.getUserId());
		m.addAttribute("profileName",user.getProfileName());
        m.addAttribute("list",contactlist);   
        return "userContact/viewContact";    
    }
	
	
	
	@PostMapping("/deleteContact")
	public String delContact(@Valid   @ModelAttribute("contact") Contact contact,Errors errors ,Model m) {
		System.out.println("inside deletecontact()----");
		System.out.println("contactname==="+contact.getFirstName());
		System.out.println("------------");
		System.out.println(errors.hasErrors());
		System.out.println("------------");
		if(errors.hasErrors())
			return "userContact/deleteContact";
		int userId=contact.getUserId();
		
		contactService.deleteContactById(contact.getContactId());
		System.out.println("user id=="+userId);
		List<Contact> contactlist=contactService.findAllUserContact(contact.getUserId());
		UserEntity user=uService.findUserByUserId(contact.getUserId());
		m.addAttribute("profileName",user.getProfileName());
		m.addAttribute("contact",new Contact());
        m.addAttribute("list",contactlist);  
		
		 return "userContact/viewContact";
	}

}
