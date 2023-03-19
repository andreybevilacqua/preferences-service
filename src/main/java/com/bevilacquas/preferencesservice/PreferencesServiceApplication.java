package com.bevilacquas.preferencesservice;

import static java.util.UUID.randomUUID;

import com.bevilacquas.preferencesservice.domain.entities.Preference;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PreferencesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreferencesServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner run(PreferencesRepository repo) {
		var a = new Preference(randomUUID(), "Preference A");
		return args -> repo.save(a);
	}
}
