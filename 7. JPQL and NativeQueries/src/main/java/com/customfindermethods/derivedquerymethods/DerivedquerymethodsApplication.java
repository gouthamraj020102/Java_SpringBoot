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

		List<User> users = userRepository.getallUsers();

		users.forEach(e -> System.out.println(e));

		List<User> userByName = userRepository.getUserByName("Gowtham");

		userByName.forEach(e -> System.out.println(e));

		List<User> userByNameAndCity = userRepository.getUserByNameAndCity("Mohan", "MVP Colony");

		userByNameAndCity.forEach(e -> System.out.println(e));

		List<User> usersall = userRepository.getUsers();

		usersall.forEach(e -> System.out.println(e));
	}

}
