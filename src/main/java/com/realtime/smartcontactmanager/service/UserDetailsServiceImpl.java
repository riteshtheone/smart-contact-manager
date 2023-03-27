package com.realtime.smartcontactmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.realtime.smartcontactmanager.config.CustomUserDetails;
import com.realtime.smartcontactmanager.dao.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = this.userRepository.findUserByEmail(email);
        if(user.isPresent()) System.out.println(user);
        if (user.isEmpty()) throw new UsernameNotFoundException("user not found" + email);
        return new CustomUserDetails(user.get());
    }
    
}
