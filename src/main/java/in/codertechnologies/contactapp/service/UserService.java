package in.codertechnologies.contactapp.service;

import java.util.List;
import in.codertechnologies.contactapp.model.UserEntity;


public interface UserService {

	boolean registerUser(UserEntity newUser);
	boolean updateProfile(int userId, UserEntity existingUser);
	boolean deleteUserByUserName(String username);
	UserEntity findUserByUserName(String username);
	UserEntity findUserByUserId(int userId);
    List<UserEntity> findAll();
	UserEntity performLogin(UserEntity user);
	List<String> findAllUserNames();
	void findIdAndName();
	String findUserNameByUserId(int id);
	boolean deleteUserById(int id);
}
