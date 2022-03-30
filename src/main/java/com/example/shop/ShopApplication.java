package com.example.shop;

import com.example.shop.model.Role;
import com.example.shop.model.User;
import com.example.shop.service.DataAccessService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner commandLineRunner(DataAccessService dataAccessService){
		return args -> {
			dataAccessService.saveRole(new Role(null,"ROLE_USER"));
			dataAccessService.saveRole(new Role(null,"ROLE_ADMIN"));
			dataAccessService.saveRole(new Role(null,"ROLE_MANAGER"));

			dataAccessService.saveUser(new User(null,"caleb","masake@gmail.com","1234",new ArrayList<>()));
			dataAccessService.saveUser(new User(null,"alice","alice@gmail.com","1234",new ArrayList<>()));
			dataAccessService.saveUser(new User(null,"bob","bob@gmail.com","1234",new ArrayList<>()));

			dataAccessService.addRoleToUser("masake@gmail.com","ROLE_USER");
			dataAccessService.addRoleToUser("alice@gmail.com","ROLE_USER");
			dataAccessService.addRoleToUser("alice@gmail.com","ROLE_ADMIN");
		};

	}


}
