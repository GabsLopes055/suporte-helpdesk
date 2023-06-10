package br.com.sicoob.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EntityScan(basePackages = "br.com.sicoob.helpdesk.entities")

public class SuporteSicoobApplication {
//	@Bean(name="entityManagerFactory")
	public static void main(String[] args) {
		SpringApplication.run(SuporteSicoobApplication.class, args);
	}

}
