package in.codertechnologies.contactapp.dao;

import java.util.List;

import in.codertechnologies.contactapp.model.Contact;
import in.codertechnologies.contactapp.model.UserEntity;

public interface ContactDao {

	List<Contact> findAllUserContact(int id);
	boolean saveContact(Contact newContact);
	boolean updateContact(int contactId ,Contact existingContact);
	boolean deleteContactByfirstAndLastNAme(String firstName,String LastName);
	List<String> findAllUserEmail();
	public Contact findeContactById(int id);
	boolean deleteContactById(int id);
}
