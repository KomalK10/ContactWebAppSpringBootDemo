package in.codertechnologies.contactapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.codertechnologies.contactapp.dao.ContactDao;
import in.codertechnologies.contactapp.model.Contact;
import in.codertechnologies.contactapp.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDao contactDao;

	
//	public ContactServiceImpl(ContactDao contactDao) {
//		
//		this.contactDao = contactDao;
//	}

	
	@Override
	public List<Contact> findAllUserContact(int id) {
		// TODO Auto-generated method stub
		return contactDao.findAllUserContact(id);
	}

	@Override
	public boolean saveContact(Contact newContact) {
		// TODO Auto-generated method stub
		return contactDao.saveContact(newContact);
	}

	@Override
	public boolean updateContact(int contactId, Contact existingContact) {
		// TODO Auto-generated method stub
		return contactDao.updateContact(contactId, existingContact);
	}

	@Override
	public boolean deleteContactByfirstAndLastNAme(String firstName, String LastName) {
		// TODO Auto-generated method stub
		return contactDao.deleteContactByfirstAndLastNAme(firstName, LastName);
	}


	@Override
	public List<String> findAllUserEmail() {
		// TODO Auto-generated method stub
		return contactDao.findAllUserEmail();
	}

	@Override
	public Contact findeContactById(int id) {
		// TODO Auto-generated method stub
		return contactDao.findeContactById(id);
	}

	@Override
	public boolean deleteContactById(int id) {
		// TODO Auto-generated method stub
		return contactDao.deleteContactById(id);
	}

	
	
	

}
