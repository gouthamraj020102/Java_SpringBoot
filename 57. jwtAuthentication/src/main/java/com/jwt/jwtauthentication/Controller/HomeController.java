package com.jwt.jwtauthentication.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/welcome")
    public String home() {
        return "Home";
    }

    @RequestMapping("/getUsers")
    public String getUsers() {
        return "{\"name\":\"Goutham\"}";
    }
}
