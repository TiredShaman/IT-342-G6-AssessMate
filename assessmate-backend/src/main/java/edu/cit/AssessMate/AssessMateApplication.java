package edu.cit.AssessMate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "edu.cit.AssessMate")
@EntityScan("edu.cit.AssessMate.Entity")
@EnableJpaRepositories("edu.cit.AssessMate.Repository")
public class AssessMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessMateApplication.class, args);
	}

}
