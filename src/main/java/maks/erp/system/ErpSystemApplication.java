package maks.erp.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ErpSystemApplication {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("Current Date: "+ date);
		SpringApplication.run(ErpSystemApplication.class, args);
	}

}
