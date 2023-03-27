package com.realtime.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realtime.smartcontactmanager.dao.ContactRepository;
import com.realtime.smartcontactmanager.entity.ContactEntity;

@Controller
@PreAuthorize("hasRole('USER')")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public String userHome(){
        return "/user/home";
    }

    @GetMapping("/dashboard")
    public String userDashboard(){
        return "user/dashboard";
    }

    @GetMapping("/viewContacts")
    public String viewContacts(){
        return "user/viewContacts";
    }

    @GetMapping("/addContact")
    public String addContact(Model model){
        model.addAttribute("contact", new ContactEntity());
        return "user/addContact";
    }

    @PostMapping("/addContact")
    public String addContactInDB(@ModelAttribute("contact") ContactEntity contact){
        this.contactRepository.save(contact);
        return "user/viewContacts";
    }
    
    @GetMapping("/about")
    public String userAbout(){
        return "user/about";
    }
}
