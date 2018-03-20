package ro.pickupservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = "ro.pickupservice")
@PropertySource(value = "file:./config/pickup.properties")
public class PickUpService {

	public static void main(String[] args) {
		SpringApplication.run(PickUpService.class, args);
		System.out.println("PickUp application started");
	}
}
