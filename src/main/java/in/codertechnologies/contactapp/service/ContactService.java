package in.codertechnologies.contactapp.service;

import java.util.List;

import in.codertechnologies.contactapp.model.Contact;

public interface ContactService {

	List<Contact> findAllUserContact(int id);
	boolean saveContact(Contact newContact);
	boolean updateContact(int contactId ,Contact existingContact);
	boolean deleteContactByfirstAndLastNAme(String firstName,String LastName);
	List<String> findAllUserEmail();
	public Contact findeContactById(int id);
	boolean deleteContactById(int id);
	

}
