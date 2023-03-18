package com.jpaexample.databaseconfiguration;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpaexample.databaseconfiguration.Repo.UserRepository;
import com.jpaexample.databaseconfiguration.entities.User;


@SpringBootApplication
public class Example5Application {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(Example5Application.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		//saving a single user
		User user1 = new User();
		
		user1.setId(1);
		user1.setName("Gowtham");
		user1.setCity("Paderu");
		user1.setStatus("I'm Java developer");
		
		User res = userRepository.save(user1);
		
		System.out.println(res);
		System.out.println("done");
		
	
		//saving multiple users
		User user2 = new User();
		user2.setName("Murali");
		user2.setCity("Parvathipuram");
		user2.setStatus("Competative aspirant");
		
		User user3 = new User();
		user3.setName("Mohan");
		user3.setCity("MVP colony");
		user3.setStatus("WNS employee");
		
		List<User> users= List.of(user2, user3);		
		Iterable<User> result = userRepository.saveAll(users);
		
		result.forEach(user->{
			System.out.println(user);
		});
		System.out.println("done");

/*
		//update the user using id
		Optional<User> optional = userRepository.findById(7);
		User user = optional.get();
		user.setName("Gowtham");
		user.setStatus("Software Engineer-I");
		User result = userRepository.save(user);
		System.out.println(result);
*/
/*		
		//how to get the data
		Iterable<User> itr = userRepository.findAll();
		
		itr.forEach(user->{System.out.println(user);});
*/
/*	
		//Deleting the user element
		userRepository.deleteById(11);
		System.out.println("deleted");

		Iterable<User> allusers = userRepository.findAll();
		allusers.forEach(user->System.out.println(user));
		userRepository.deleteAll(allusers);
		System.out.println("All elements deleted");
*/
	}

}
