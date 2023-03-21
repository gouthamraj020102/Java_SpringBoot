package com.springboot.thymeleaf.Controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	//http://localhost:8080/about
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("In about handler");
		
		//putting data in model
		model.addAttribute("name", "Gowtham Raju");
		model.addAttribute("currentDate", new Date().toLocaleString());
		return "about";
		//about.html
	}

}
