package com.realtime.smartcontactmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminDashboard(){
        return "/admin/dashboard";
    }
    
}
