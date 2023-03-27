package com.realtime.smartcontactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.realtime.smartcontactmanager.bean.UserBean;
import com.realtime.smartcontactmanager.dao.UserRepository;
import com.realtime.smartcontactmanager.entity.UserEntity;
import com.realtime.smartcontactmanager.helper.Config;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String signUp(Model model){
        model.addAttribute("title", "Sign up -SmartContactManager");
        model.addAttribute("userBean", new UserBean());
        return "signup";
    }
    
    @PostMapping
    public String doSignUp(@Valid @ModelAttribute("userBean") UserBean userBean,BindingResult bindingResult, Model model, HttpSession session){
        try {
            if (!userBean.isAgreement()) throw new Exception("you have not accepted the terms and conditions");
            else if (userRepository.findUserByEmail(userBean.getEmail()) != null) throw new Exception("email already exist");
            else if (bindingResult.hasErrors()) throw new Exception("bad credientials");
            var userEntity = new UserEntity(userBean.getName(), userBean.getEmail(), passwordEncoder.encode(userBean.getPassword()), userBean.getDescription());
            var responce = userRepository.save(userEntity);
            System.out.println(responce);
            session.setAttribute("message", new Config("Registerd successfully!!!", "alert-success"));
            model.addAttribute("userBean", new UserBean());
            return "signup";
        } catch (Exception e) {
            System.err.println(e);
            session.setAttribute("message", new Config(e.getMessage(), "alert-danger"));
            return "signup";
        }
    }
    
}