package com.springboot.thymeleaf.Controllers;

import java.time.LocalDateTime;
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

	// create a list, set a collection
	@GetMapping("/loop")
	public String iteratehandler(Model model) {
		List<String> names = List.of("Seetha", "Geetha", "Sheela", "Maala");
		model.addAttribute("names", names);
		System.out.println("In iterate handler");
		return "iterate";
	}

	// http://localhost:8080/condition
	// handler for conditional statements
	@GetMapping("/condition")
	public String conditionHandler(Model model) {
		model.addAttribute("isActive", true);
		model.addAttribute("gender", "F");
		List<Integer> lists = List.of(10, 11);
		model.addAttribute("list", lists);
		System.out.println("Conditional handler executed...");
		return "condition";
	}

	// handler for including fragments
	@GetMapping("/service")
	public String servicesHandler(Model model) {
		model.addAttribute("title", "Titanic");
		model.addAttribute("subtitle", LocalDateTime.now().toString());
		System.out.println("In service handler");
		return "service";
	}

}
