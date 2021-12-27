package in.codertechnologies.contactapp.model;

import javax.validation.constraints.NotEmpty;

import in.codertechnologies.contactapp.controller.ContactController.addContactValidation;

public class Contact {

	private int contactId;
	@NotEmpty(message = "User Name Required",groups= {addContactValidation.class})
	private String firstName;
	@NotEmpty
	private String lastname;
	@NotEmpty
	private String email;
	@NotEmpty
	private String mobile;
	private int userId;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
