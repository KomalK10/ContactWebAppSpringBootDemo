package in.codertechnologies.contactapp.dao;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;

import in.codertechnologies.contactapp.model.UserEntity;

public interface UserDao{

	boolean save(UserEntity newUser);
	boolean updateProfile(int userId ,UserEntity existingUser);
	boolean deleteUserByUserName(String username);
	UserEntity findUserByUserName(String username);
	UserEntity findUserByUserId(int userId);
    List<UserEntity> findAll();
    UserEntity performLogin(UserEntity newUser);
	String findUserNameByUserId(int userId);
	void findIdAndName();
	List<String> findAllUserNames();
	boolean deleteUserById(int id);
	
}
	
