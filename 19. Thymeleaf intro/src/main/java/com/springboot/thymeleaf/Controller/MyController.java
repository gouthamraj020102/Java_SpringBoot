package com.springboot.thymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		System.out.println("In about handler");
		return "about";
		//about.html
	}

}
