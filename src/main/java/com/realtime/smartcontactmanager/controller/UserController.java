package com.realtime.smartcontactmanager.controller;

import com.realtime.smartcontactmanager.dao.UserRepository;
import com.realtime.smartcontactmanager.entity.UserEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realtime.smartcontactmanager.dao.ContactRepository;
import com.realtime.smartcontactmanager.entity.ContactEntity;

import java.security.Principal;
import java.util.List;

@Controller
@PreAuthorize("hasRole('USER')")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;

//    @ModelAttribute
//    public void modelAttribute(Model model, Principal principal){
//        var username = principal.getClass();
//        System.out.println(username);
////        var userEntity = this.userRepository.findUserByEmail(username);
////        if (userEntity.isPresent()){
////        System.out.println("user" + userEntity);
////        model.addAttribute("user", userEntity);
//        }
//    }

    @GetMapping
    public String userHome(){
        return "/user/home";
    }

    @GetMapping("/about")
    public String userAbout(){
        return "user/about";
    }

    @GetMapping("/dashboard")
    public String userDashboard(){
        return "user/dashboard";
    }

    @GetMapping("/viewContacts")
    public String viewContacts(){
        return "user/viewContacts";
    }

    @GetMapping("/profile")
    public String showProfile(){
        return "user/profile";
    }

    @GetMapping("/addContact")
    public String addContact(Model model){
        model.addAttribute("contact", new ContactEntity());
        return "user/addContact";
    }

    @PostMapping("/addContact")
    public String addContactInDB(@ModelAttribute("contact") ContactEntity contact, HttpSession session){
        try {
            var email = session.getAttribute("userEmail").toString();
            var optional = this.userRepository.findUserByEmail(email);
            if (optional.isPresent()){
                UserEntity user = optional.get();
                List<ContactEntity> contacts = user.getContacts();
                contacts.add(contact);
                user.setContacts(contacts);
                System.out.println("after set contacts in user " + user);
                this.userRepository.save(user);
            }
            this.contactRepository.save(contact);
            return "user/viewContacts";
        }catch (DataIntegrityViolationException e){
//            e.printStackTrace();
//            System.out.println(e.getMessage());
            System.out.println("----------------------");
//            System.out.println(e.getCause());
            System.out.println("----------------------");
//            System.out.println(e.getClass());
            System.out.println("---------------------");
//            System.out.println(e.getLocalizedMessage());
            return "user/addContact";
        }
    }

}
