// package com.realtime.smartcontactmanager.service;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Component;

// import com.realtime.smartcontactmanager.config.CustomUserDetails;
// import com.realtime.smartcontactmanager.dao.UserRepository;
// import com.realtime.smartcontactmanager.entity.User;

// @Component
// public class UserDetailsServiceImpl implements UserDetailsService {

//     @Autowired
//     private UserRepository userRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Optional<User> user = userRepository.findByEmail(username);
//         return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found" + username));
//     }
    
// }
