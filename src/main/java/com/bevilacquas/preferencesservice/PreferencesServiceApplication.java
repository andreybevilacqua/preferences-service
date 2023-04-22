package com.bevilacquas.preferencesservice;

import static java.util.List.of;
import static java.util.UUID.randomUUID;

import com.bevilacquas.preferencesservice.domain.entities.Preference;
import com.bevilacquas.preferencesservice.domain.entities.User;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import com.bevilacquas.preferencesservice.infrastructure.persistence.UsersRepository;
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
	ApplicationRunner run(PreferencesRepository preferencesRepo, UsersRepository usersRepo) {
		var p1 = new Preference(randomUUID(), "Preference A");
		var u1 = new User(randomUUID(), "Andrey");
		var u2 = new User(randomUUID(), "Vinicius");
		return args -> {
			preferencesRepo.save(p1);
			usersRepo.saveAll(of(u1, u2));
		};
	}
}
