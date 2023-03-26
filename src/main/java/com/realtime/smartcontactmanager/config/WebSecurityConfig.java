package com.realtime.smartcontactmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// import com.realtime.smartcontactmanager.service.CustomUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {     // this is the configuration of security in which who can access which url and who cannot
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService getUserDetailsService(){      // this is the details of user who access particular url which I assigned with it
        var admin = User.withUsername("admin").password(this.passwordEncoder().encode("admin")).roles("ADMIN").build();
        var user = User.withUsername("user").password(this.passwordEncoder().encode("user")).roles("USER").build();
        return new InMemoryUserDetailsManager(admin,user);
        // return new CustomUserDetailsService();
    }

    // @Bean
    //  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http.csrf(withDefaults())
    //         .authorizeHttpRequests(authorize -> authorize
    //             .requestMatchers("/admin/**").hasRole("ADMIN")
    //             .requestMatchers("/user/**").hasRole("USER")
    //             .requestMatchers("/**").permitAll())
    //         .formLogin(form -> form.loginPage("/signin"))
    //         .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/"))
	// 	    .exceptionHandling(access -> access.accessDeniedPage("/accessDenied"));
    //     return http.build();
    //  }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                // .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/**").permitAll())
            .formLogin(withDefaults());
        return http.build();
    }

}
