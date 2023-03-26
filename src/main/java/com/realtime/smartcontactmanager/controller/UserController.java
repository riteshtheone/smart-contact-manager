package com.realtime.smartcontactmanager.controller;

// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String userDashboard(){
        return "user/dashboard";
    }
    
}
