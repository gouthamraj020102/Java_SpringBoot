package com.project.smartContactManager.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.smartContactManager.Entities.Contact;
import com.project.smartContactManager.Entities.User;
import com.project.smartContactManager.Repositories.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Method for adding common data to response
    @ModelAttribute
    public void addCommonData(Model model, Principal principal) {
        String username = principal.getName();
        System.out.println("USERNAME is = " + username);

        // get the user using userName(Email)
        User user = this.userRepository.getUserByUserName(username);
        System.out.println("USER details are: " + user);
        model.addAttribute("user", user);
    }

    // Dashboard home
    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("title", "User Dashboard");
        return "normal/user_dashboard";
    }

    // open add form handler
    @GetMapping("/add-contact")
    public String addContactForm(Model model) {
        model.addAttribute("title", "Add Contact");
        model.addAttribute("contact", new Contact());
        return "normal/add_contact_form";
    }

    // processing add contact form
    @PostMapping("/process-contact")
    public String processContact(@ModelAttribute Contact contact, Principal principal) {

        String name = principal.getName();
        User user = userRepository.getUserByUserName(name);
        contact.setUser(user);
        user.getContacts().add(contact);
        this.userRepository.save(user);

        System.out.println("Added to database");
        return "normal/add_contact_form";
    }
}
