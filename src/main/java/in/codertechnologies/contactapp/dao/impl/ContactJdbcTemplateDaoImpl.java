package in.codertechnologies.contactapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import in.codertechnologies.contactapp.dao.ContactDao;
import in.codertechnologies.contactapp.model.Contact;
import in.codertechnologies.contactapp.model.UserEntity;



@Repository
public class ContactJdbcTemplateDaoImpl implements ContactDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Value("${user_contact.updateContactSql}")
	private String updateContactSql;
	
	@Value("${user_contact.deleteContactSql}")
	private String deleteContactSql;
	
	@Value("${user_contact.insertContactSql}")
	private String insertContactSql;
	
	
//	@Autowired
//	public ContactJdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate) 
//	{
//		this.jdbcTemplate = jdbcTemplate;		
//	} 
	
	
	public String getUpdateContactSql() {
		return updateContactSql;
	}


	public void setUpdateContactSql(String updateContactSql) {
		this.updateContactSql = updateContactSql;
	}


	public String getDeleteContactSql() {
		return deleteContactSql;
	}


	public void setDeleteContactSql(String deleteContactSql) {
		this.deleteContactSql = deleteContactSql;
	}


	public String getInsertContactSql() {
		return insertContactSql;
	}


	public void setInsertContactSql(String insertContactSql) {
		this.insertContactSql = insertContactSql;
	}


	
	

	@Override
	public boolean saveContact(Contact newContact) {
		jdbcTemplate.update(insertContactSql, newContact.getFirstName(),newContact.getLastname(),newContact.getEmail(),newContact.getMobile(),newContact.getUserId());
		return true;
	}

	@Override
	public boolean updateContact(int contactId, Contact existingContact) {
		int rowCount=0;
		rowCount=jdbcTemplate.update(updateContactSql, existingContact.getFirstName(),existingContact.getLastname(),existingContact.getEmail(),existingContact.getMobile(),contactId);
		
		System.out.println("Row updated in table user_contact="+rowCount);
		return true;
	}

	@Override
	public boolean deleteContactByfirstAndLastNAme(String firstName, String LastName) {
		int rowCount=0;
		rowCount=jdbcTemplate.update(deleteContactSql,firstName,LastName );
		System.out.println("Row deleted in table user_contact="+rowCount);
		return true;
	}
	
	public List<Contact> findAllUserContact(int userId)
	{
		return jdbcTemplate.query("SELECT * FROM user_contact where fki_user_id=?", new ContactRowMapper(),userId);
	}
	
	class ContactRowMapper implements RowMapper<Contact> 
	{

		@Override
		public Contact mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			
		
			Contact objContact=new Contact();
			objContact.setContactId(resultSet.getInt("user_contact_id"));
			objContact.setFirstName(resultSet.getString("user_first_name"));
			objContact.setLastname(resultSet.getString("user_last_name"));
			objContact.setEmail(resultSet.getString("user_email_id"));
			objContact.setMobile(resultSet.getString("user_mobile_no"));
			objContact.setUserId(resultSet.getInt("fki_user_id"));
			return objContact;
		}
	}
	
	public List<String> findAllUserEmail()
	{
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForList("SELECT user_email_id FROM user_contact", String.class);
	}


	@Override
	public Contact findeContactById(int id) {

		return jdbcTemplate.queryForObject("SELECT * FROM user_contact where user_contact_id=?", new ContactRowMapper(),id);
		
	}


	@Override
	public boolean deleteContactById(int id) {
		
		int rowCount=0;
		rowCount=jdbcTemplate.update("delete from user_contact where user_contact_id=?",id);
		System.out.println("Row deleted in table user_contact="+rowCount);
		return true;
	}


	



}
