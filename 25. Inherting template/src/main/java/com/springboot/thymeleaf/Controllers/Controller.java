package com.springboot.thymeleaf.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	// for new about
	@GetMapping("/newabout")
	public String newAbout() {
		return "aboutnew";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

}
