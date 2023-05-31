package com.project.smartContactManager.Controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.smartContactManager.Entities.Contact;
import com.project.smartContactManager.Entities.User;
import com.project.smartContactManager.Helper.Message;
import com.project.smartContactManager.Repositories.ContactRepository;
import com.project.smartContactManager.Repositories.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

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
    public String processContact(@ModelAttribute Contact contact, @RequestParam("profileImage") MultipartFile file,
            Principal principal, HttpSession session) {

        try {
            String name = principal.getName();
            User user = userRepository.getUserByUserName(name);
            contact.setImage("contact.png");
            if (file.isEmpty()) {
                System.out.println("Image file is empty");

            } else {
                contact.setImage(file.getOriginalFilename());
                File savefile = new ClassPathResource("static/image").getFile();
                Path path = Paths.get(savefile.getAbsolutePath() + File.separator + file.getOriginalFilename());

                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image is uploaded");
            }

            user.getContacts().add(contact);
            contact.setUser(user);
            this.userRepository.save(user);

            System.out.println("Added to database");
            // message success
            session.setAttribute("message", new Message("Your contact is added!! Add more...", "success"));
        } catch (Exception e) {
            System.out.println("ERROR" + e.getMessage());
            e.printStackTrace();
            // message error
            session.setAttribute("message", new Message("Something went wrong!! Try again...", "danger"));
        }
        return "normal/add_contact_form";
    }

    // show contacts handler
    @GetMapping("/show-contacts/{page}")
    public String showContacts(@PathVariable("page") Integer page, Model m, Principal principal) {

        String userName = principal.getName();
        User user = this.userRepository.getUserByUserName(userName);

        Pageable pageable = PageRequest.of(page, 3);
        Page<Contact> contacts = this.contactRepository.findContactsByUser(user.getId(), pageable);
        m.addAttribute("title", "View Contacts");
        m.addAttribute("contacts", contacts);
        m.addAttribute("currentPage", page);
        m.addAttribute("totalPages", contacts.getTotalPages());
        return "normal/show_contacts";
    }

    // showing particular contact details
    @GetMapping("/{cId}/contact")
    public String showContactDetail(@PathVariable("cId") Integer cId, Model model, Principal principal) {
        Optional<Contact> contactOptional = this.contactRepository.findById(cId);
        Contact contact = contactOptional.get();
        String userName = principal.getName();
        User user = this.userRepository.getUserByUserName(userName);
        if (user.getId() == contact.getUser().getId()) {
            model.addAttribute("contact", contact);
            model.addAttribute("title", contact.getName());
        }
        return "normal/contact_detail";
    }

    // delete contact handler
    @GetMapping("/delete/{cId}")
    public String deleteContact(@PathVariable("cId") Integer cId, Model model, HttpSession session,
            Principal principal) {

        Contact contact = this.contactRepository.findById(cId).get();
        User user = this.userRepository.getUserByUserName(principal.getName());
        user.getContacts().remove(contact);
        this.userRepository.save(user);
        // contact.setUser(null);
        // this.contactRepository.delete(contact);
        System.out.println("DELETED");
        session.setAttribute("message", new Message("Contact deleted successfully...", "success"));
        return "redirect:/user/show-contacts/0";
    }

    // open update form handler
    @PostMapping("/update-contact/{cId}")
    public String updateForm(@PathVariable("cId") Integer cId, Model m) {
        m.addAttribute("title", "Update Contact");
        Contact contact = this.contactRepository.findById(cId).get();
        m.addAttribute("contact", contact);
        return "normal/update_form";
    }

    // update contact handler
    @PostMapping("/process-update")
    public String updateHandler(@ModelAttribute Contact contact, @RequestParam("profileImage") MultipartFile file,
            Model m, HttpSession session, Principal principal) {
        try {
            // old contact details
            Contact oldContactDetails = this.contactRepository.findById(contact.getcId()).get();
            if (!file.isEmpty()) {

                // delete image
                File deletefile = new ClassPathResource("static/image").getFile();
                File img = new File(deletefile, oldContactDetails.getImage());
                img.delete();

                // update image
                File savefile = new ClassPathResource("static/image").getFile();
                Path path = Paths.get(savefile.getAbsolutePath() + File.separator + file.getOriginalFilename());

                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                contact.setImage(file.getOriginalFilename());
            } else {
                contact.setImage(oldContactDetails.getImage());
            }
            User user = this.userRepository.getUserByUserName(principal.getName());
            contact.setUser(user);
            this.contactRepository.save(contact);
            session.setAttribute("message", new Message("Your contact is updated...!", "success"));

        } catch (Exception ex) {

        }
        return "redirect:/user/" + contact.getcId() + "/contact";
    }

    // your profile handler
    @GetMapping("/profile")
    public String yourProfile(Model model) {
        model.addAttribute("title", "Profile Page");
        return "normal/profile";
    }
}
