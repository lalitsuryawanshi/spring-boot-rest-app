package org.se.bou.quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.se.bou.quote")
@SpringBootApplication
public class QuoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteApplication.class, args);
	}
}
