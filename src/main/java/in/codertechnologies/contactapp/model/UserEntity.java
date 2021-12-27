package in.codertechnologies.contactapp.model;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.validation.annotation.Validated;

import in.codertechnologies.contactapp.controller.UserController.loginValidation;
import in.codertechnologies.contactapp.controller.UserController.registrationValidation;

//@XmlRootElement
public class UserEntity {
	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", profileName="
				+ profileName + ", active=" + active + ", type=" + type + "]";
	}
	//PK and auto increment
	private int userId;
	
	//UK not null
	
	@NotEmpty(message = "User Name Required")
	
	private String username;
	
	@NotEmpty(message = "Password Required")
	private String password;
	
	
	//@NotEmpty(message = "Profile Name Required", groups= {registrationValidation.class,loginValidation.class})
	private String profileName;
	private boolean active;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	


}
