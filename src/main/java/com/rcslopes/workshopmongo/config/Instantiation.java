package com.rcslopes.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rcslopes.workshopmongo.domain.User;
import com.rcslopes.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	
		userRepository.deleteAll();
				
		User maria = new User(null, "Maria Laura", "maria@gmail.com"); 
		User anne = new User(null, "Anne Moura", "anne@gmail.com"); 
		User rodrigo = new User(null, "Rodrigo Lopes", "rodrilop@gmail.com"); 
		
		userRepository.saveAll(Arrays.asList(maria,anne,rodrigo));
		
	}

}
