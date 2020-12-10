package com.in28minutes.springboot.jpa;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class UserCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception{
		repository.save(new User("Ranga", "Admin"));
		repository.save(new User("Lasitha", "User"));
		
		for(User user : repository.findAll() )
		{
			log.info(user.toString());
		}
		
		log.info("Admin users are......");
		log.info("---------------------");
		for(User user : repository.findByRole("Admin"))
		{
			log.info(user.toString());
		}
	}
}
