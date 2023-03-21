package com.springboot.thymeleaf.Controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("/about")
	public String about() {
		System.out.println("In about handler");
		return "about";
	}
	
	@GetMapping("/loop")
	public String iteratehandler(Model model) {
		List<String> names = List.of("Seetha", "Geetha", "Sheela", "Maala");
		model.addAttribute("names", names);
		System.out.println("In iterate handler");
		return "iterate";
	}

}
