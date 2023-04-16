package com.project.smartContactManager.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.smartContactManager.Entities.User;
import com.project.smartContactManager.Repositories.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal) {
        String username = principal.getName();
        System.out.println("USERNAME is = " + username);
        User user = this.userRepository.getUserByUserName(username);
        System.out.println("USER details are: " + user);
        model.addAttribute("user", user);
        return "normal/user_dashboard";
    }
}
