package in.codertechnologies.contactapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import in.codertechnologies.contactapp.dao.UserDao;
import in.codertechnologies.contactapp.model.UserEntity;


/** tbl_user */
@Repository
public class UserJdbcTemplateDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	KeyHolder generatedKeyHolder=new GeneratedKeyHolder();
	
	public void insertauto() {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement ps=con.prepareStatement("", Statement.RETURN_GENERATED_KEYS);
				
				return ps;
			}
		},generatedKeyHolder);
		
		int i=generatedKeyHolder.getKey().intValue();
	}

//	public UserJdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate) {
//	
//		this.jdbcTemplate = jdbcTemplate;
//	}


	//@Value("INSERT INTO user_master(name,user_name,password) VALUES(?,?,?)")
	@Value("${user.insertSql}")//adding query in @value is again hardcoding,to avoid that we make seperate file i.e. database.properties and give instruction to spring to fetch this file 
	private String insertSql;
	
	//@Value("UPDATE user_master SET name=?,user_name=?,password=? WHERE user_id=?")
	@Value("${user.updateSql}")
	private String updateSql;
	
	//@Value("DELETE FROM user_master WHERE name=?")
	@Value("${user.deleteSql}")
	private String deleteSql;
	
	//@Value("SELECT  * FROM user_master")
	@Value("${user.selSql}")
	private String selSql;
	
	
	//@Value("SELECT  * FROM user_master WHERE user_id=?")
	@Value("${user.selByIdSql}")
	private String selByIdSql;
	
	
	//@Value("SELECT  * FROM user_master WHERE user_name=?")
	@Value("${user.selByNameSql}")
	private String selByNameSql;
	
	
	//@Value("SELECT * FROM user_master WHERE user_name=? AND password=? AND active=true")
	@Value("${user.loginSql}")
	private String loginSql;
	
	

	public String getUpdateSql() {
		return updateSql;
	}

	public void setUpdateSql(String updateSql) {
		this.updateSql = updateSql;
	}

	public String getDeleteSql() {
		return deleteSql;
	}

	public void setDeleteSql(String deleteSql) {
		this.deleteSql = deleteSql;
	}

	public String getSelSql() {
		return selSql;
	}

	public void setSelSql(String selSql) {
		this.selSql = selSql;
	}

	public String getSelByIdSql() {
		return selByIdSql;
	}

	public void setSelByIdSql(String selByIdSql) {
		this.selByIdSql = selByIdSql;
	}

	public String getSelByNameSql() {
		return selByNameSql;
	}

	public void setSelByNameSql(String selByNameSql) {
		this.selByNameSql = selByNameSql;
	}

	public String getLoginSql() {
		return loginSql;
	}

	public void setLoginSql(String loginSql) {
		this.loginSql = loginSql;
	}

	public String getInsertSql() {
		return insertSql;
	}

	
	
	public void setInsertSql(String insertSql) {
		this.insertSql = insertSql;
	}

	

	//-------------------------------
	//Cohesion - high cohesion
	public boolean save(UserEntity newUser)
	{
		jdbcTemplate.update(insertSql,newUser.getProfileName(), newUser.getUsername(),newUser.getPassword());
		return true;
	}

	@Override
	public UserEntity findUserByUserId(int userId) 
	{
		return jdbcTemplate.queryForObject(selByIdSql, new UserRowMapper() , userId);
	}

	
	@Override
	public List<String> findAllUserNames()
	{
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForList("SELECT name FROM user_master", String.class);
	}
	
	
	@Override
	public void findIdAndName()
	{
		System.out.println("inside findid and name");
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT user_id, name FROM user_master WHERE user_id = ?";
		Map<String, Object> queryForMap = jdbcTemplate.queryForMap(sql,6);
		System.out.println("ID and Name of User:\n"+queryForMap);
			
	}

	@Override
	public List<UserEntity> findAll() 
	{
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query("SELECT * FROM user_master", new UserRowMapper());
	}

	class UserRowMapper implements RowMapper<UserEntity> 
	{

		@Override
		public UserEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			
			UserEntity foundUser = new UserEntity();
			
			foundUser.setUserId(resultSet.getInt("user_id"));
			foundUser.setUsername(resultSet.getString("user_name"));
			foundUser.setProfileName(resultSet.getString("name"));
			foundUser.setPassword(resultSet.getString("password"));
			foundUser.setActive(resultSet.getBoolean("enabled"));
			if(resultSet.getBoolean("enabled"))
			foundUser.setStatus("Active");
			else
				foundUser.setStatus("Inactive");	
			return foundUser;
		}
	}
	

	


	@Override
	public String findUserNameByUserId(int userId) 
	{
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForObject("SELECT user_name FROM user_master WHERE user_id = ?", String.class , userId );		
	}

	

	@Override
	public UserEntity findUserByUserName(String username) 
	{

		return jdbcTemplate.queryForObject(selByNameSql, new UserRowMapper() , username);
		
	}


	@Override
	public boolean updateProfile(int userId, UserEntity existingUser) 
	{	int rowId=0;
		if(existingUser.getStatus().equals("Active")) {
			existingUser.setActive(true);
		}else {
			existingUser.setActive(false);
		}
		jdbcTemplate.update(updateSql, existingUser.getUsername(),existingUser.getProfileName(),existingUser.getPassword(),existingUser.isActive(),userId);
		System.out.println("row updated is==="+rowId);
		return true;
	}

	@Override
	public boolean deleteUserByUserName(String username) {
		int rowId=0;
		rowId=jdbcTemplate.update(deleteSql,username);
		System.out.println("row deleted is==="+rowId);
		return true;
	}

	@Override
	public UserEntity performLogin(UserEntity newUser) {
		
		
			List<UserEntity> users=jdbcTemplate.query(loginSql, new UserRowMapper(), newUser.getUsername(),newUser.getPassword());
			System.out.println("list size====="+users.size());
			if(users.size()>0)
				return users.get(0);
			else
				return	null;
	}

	@Override
	public boolean deleteUserById(int id) {
		int rowCount=0;
		rowCount=jdbcTemplate.update("delete from user_master where user_id=?",id);
		System.out.println("Row deleted in table user_master="+rowCount);
		return true;
	}


//	@Override
//	public User performLogin(String username, String password) {
//		try {
//			return jdbcTemplate.queryForObject(loginSql,new UserRowMapper());
//			
//		}catch(Exception e) {
//			System.out.println(e);  
//		}
//		
//		
//		return null;
//		
//	}

	
	
	
	
	


}
