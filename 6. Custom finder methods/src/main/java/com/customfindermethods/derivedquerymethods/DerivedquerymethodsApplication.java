package com.customfindermethods.derivedquerymethods;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.customfindermethods.derivedquerymethods.Repo.UserRepository;
import com.customfindermethods.derivedquerymethods.entities.User;

@SpringBootApplication
public class DerivedquerymethodsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DerivedquerymethodsApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
/*		
		List<User> users = userRepository.findByName("Gowtham");
		users.forEach(e->System.out.println(e));
*/		
		//spring data support keywords
		//Reference Link: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

		List<User> users = userRepository.findByNameAndCity("Mohan", "MVP colony");
		users.forEach(e->System.out.println(e));

/*
		findByNameStartingWith(String prefix)
		findByNameEndingWith(String suffix)
		findByNameContaining(String words)
		
		findByNameLike(String likePattern)
		
		findByAgeLessThan(int age)
		
		findByAgeGreaterThanEqual(int age)
		
		findByAgeIn(Collection<Integer> ages)
		
		findByNameOrderByName(String name)
*/
	}

}
