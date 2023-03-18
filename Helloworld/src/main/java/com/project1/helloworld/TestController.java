package com.project1.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Welcome to Spring Boot";
	}
}
