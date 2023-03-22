package com.project.smartContactManager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smartContactManager.Entities.Contact;
import com.project.smartContactManager.Entities.User;
import com.project.smartContactManager.Repositories.UserRepository;

@RestController
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/test")
	public String test() {
		User user = new User();
		user.setName("Gowtham");
		user.setEmail("goutham@gmail.com");
		
		Contact contact = new Contact();
		user.getContacts().add(contact);
		userRepository.save(user);
		return "working";
	}
}
