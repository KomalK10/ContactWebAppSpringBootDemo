package in.codertechnologies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication

public class ContactappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactappApplication.class, args);
		System.out.println("inside codertechnologies contactapp----------");
	}

}
