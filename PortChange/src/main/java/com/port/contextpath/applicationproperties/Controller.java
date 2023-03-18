package com.port.contextpath.applicationproperties;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		System.out.println("Hello World !");
		return "Hello World!";
	}

}