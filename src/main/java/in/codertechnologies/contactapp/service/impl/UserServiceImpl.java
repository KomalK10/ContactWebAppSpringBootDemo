package in.codertechnologies.contactapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import in.codertechnologies.contactapp.dao.UserDao;
import in.codertechnologies.contactapp.model.UserEntity;
import in.codertechnologies.contactapp.service.UserService;

//DI - Dependency Injection

//Dependent
@Service
//@Repository
public class UserServiceImpl implements UserService
{

	//Dependency
	@Autowired
	private UserDao userDao; //Coding to interfaces

	
	
	
	

	
	//@Autowired
//	public UserServiceImpl(UserDao userDao)
//	{
//		System.out.println("In UserServiceImpl()");
//		this.userDao = userDao;
//	}
	
	//Setter Injection
//	@Autowired
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
//	
	
	public boolean registerUser(UserEntity newUser)
	{
		//UserJdbcDaoImpl daoImpl = new UserJdbcDaoImpl();
		
								//Tight Coupling
		//userDao = new UserJdbcDaoImpl();
		return userDao.save(newUser);
	}
	
	public boolean updateProfile(int userId, UserEntity existingUser)
	{
		//UserJdbcDaoImpl daoImpl = new UserJdbcDaoImpl();
		
								//Tight Coupling
		//userDao = new UserJdbcDaoImpl();
		return userDao.updateProfile(userId, existingUser);
	}

	@Override
	public boolean deleteUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.deleteUserByUserName(username);
	}

	@Override
	public UserEntity findUserByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserName(username);
	}

	@Override
	public UserEntity findUserByUserId(int userId) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserId(userId);
	}

	@Override

	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		
		return userDao.findAll();
	}


	@Override
	public List<String> findAllUserNames() {
		// TODO Auto-generated method stub
		return userDao.findAllUserNames();
	}

	@Override
	public void findIdAndName() {
		// TODO Auto-generated method stub
		userDao.findIdAndName();
	}

	@Override
	public String findUserNameByUserId(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserNameByUserId(id);
	}

	@Override
	public UserEntity performLogin(UserEntity user) {
		// TODO Auto-generated method stub
		return userDao.performLogin(user);
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteUserById(id);
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		final UserEntity u1=userDao.findUserByUserName(username);
//		if (u1 == null) {
//            throw new UsernameNotFoundException(username);
//        }
//		
//		 UserDetails user = User.withUsername(u1.getUsername())
//            .password(u1.getPassword())
//            .authorities("USER").build();
//        return user;
//	}

//	@Override
//	public User performLogin(User existingUser) {
//
//
//		if(existingUser.getUsername().equals("admin") && existingUser.getPassword().equals("admin"))
//		{
//			return existingUser;
//		}
//		
//		throw new RuntimeException("User not Found");
//
//	}
	

	
	
	
	
	
	
}
