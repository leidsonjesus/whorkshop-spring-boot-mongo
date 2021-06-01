package com.leidsonjesus.whorkshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.leidsonjesus.whorkshopmongo.domain.User;
import com.leidsonjesus.whorkshopmongo.repository.UserRepository;

@Configuration	
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository	userReposiroty;
		
	@Override
	public void run(String... args) throws Exception {
		
		userReposiroty.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}