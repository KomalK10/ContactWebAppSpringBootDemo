package in.codertechnologies.contactapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomValidate implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		
		
	}

}
