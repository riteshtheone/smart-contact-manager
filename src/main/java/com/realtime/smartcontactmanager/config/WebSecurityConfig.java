package com.realtime.smartcontactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.realtime.smartcontactmanager.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {     // this is the configuration of security in which who can access which url and who cannot
    
    @Autowired 
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean 
    public UserDetailsService getUserDetailsService(){      // this is the details of user who access particular url which I assigned with it
        // var admin = User.withUsername("admin").password(this.passwordEncoder().encode("admin")).roles("ADMIN").build();
        // var user = User.withUsername("user").password(this.passwordEncoder().encode("user")).roles("USER").build();
        // return new InMemoryUserDetailsManager(admin,user);
        return userDetailsServiceImpl;
    }

    @Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(this.getUserDetailsService());
		authenticationProvider.setPasswordEncoder(this.passwordEncoder());
		return authenticationProvider;
	}

    @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                // .requestMatchers("/admin/**").hasRole("ADMIN")
                // .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/**").permitAll())
            .formLogin(form -> form
                .loginPage("/signin")
                .loginProcessingUrl("/signin")
                .defaultSuccessUrl("/user"))
            .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).logoutSuccessUrl("/"))
		    .exceptionHandling(access -> access.accessDeniedPage("/accessDenied"))
            .authenticationProvider(authenticationProvider());
        return http.build();
     }

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     // http.authorizeHttpRequests((authorize) -> authorize
    //     //         .requestMatchers("/admin/**").hasRole("ADMIN")
    //     //         .requestMatchers("/user/**").hasRole("USER")
    //     //         .requestMatchers("/**").permitAll())
    //     //         .formLogin(login -> login
    //     //                 .loginPage("/signin")
    //     //                 .loginProcessingUrl("/signin")
    //     //                 .defaultSuccessUrl("/success"))
    //     //         .logout((logout) -> logout
    //     //             .deleteCookies("remove")
    //     //             .invalidateHttpSession(false)
    //     //             .logoutUrl("/logout")
    //     //             .logoutSuccessUrl("/success"));
        
    //     http.authorizeHttpRequests((authorize) -> authorize
    //             .requestMatchers("/admin/**").hasRole("ADMIN")
    //             .requestMatchers("/user/**").hasRole("USER")
    //             .requestMatchers("/**").permitAll())
    //             .formLogin(withDefaults());
    //     return http.build();
    // }

}
