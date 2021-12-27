package in.codertechnologies.contactapp.controller.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import in.codertechnologies.contactapp.model.UserEntity;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value= {RuntimeException.class,ArrayIndexOutOfBoundsException.class})
	public String handleExpception(RuntimeException e,Model m) {
		System.out.println("inside exception handler-----");
		m.addAttribute("user",new UserEntity());
		m.addAttribute("errorMsg", "Invalid Credentails");
		return "user/login";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleGenericExpception(Exception e,Model m) {
		System.out.println("inside generic exception handler-----");
		m.addAttribute("user",new UserEntity());
		m.addAttribute("errorMsg", "Invalid Credentails");
		return "error";
	}
	
	
	
	
}
