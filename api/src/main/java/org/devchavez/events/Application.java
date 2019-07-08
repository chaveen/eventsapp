package org.devchavez.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.devchavez.events")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
