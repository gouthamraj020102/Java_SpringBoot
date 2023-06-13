package com.project.smartContactManager.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.smartContactManager.Entities.Contact;
import com.project.smartContactManager.Entities.User;
import com.project.smartContactManager.Repositories.ContactRepository;
import com.project.smartContactManager.Repositories.UserRepository;

@RestController
public class SearchController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/search/{query}")
    public ResponseEntity<?> search(@PathVariable("query") String query, Principal principal) {
        User user = this.userRepository.getUserByUserName(principal.getName());
        System.out.println(query);
        List<Contact> contacts = this.contactRepository.findByNameContainingAndUser(query, user);
        return ResponseEntity.ok(contacts);
    }
}
