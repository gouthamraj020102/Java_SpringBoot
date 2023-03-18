package com.project2.springbootjspview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		System.out.println("This is my Home Page");
		return "home";
	}

	@RequestMapping("/contact")
	public String contact() {
		System.out.println("This is a Contact page");
		return "contact";
	}
}
