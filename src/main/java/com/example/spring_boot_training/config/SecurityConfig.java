//package com.example.spring_boot_training.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
////    @Autowired
//    private final PasswordEncoder passwordEncoder;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/hierDarfJederRein").permitAll()
//                .anyRequest().authenticated().and().httpBasic();
//
//        return http.build();
//    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//                UserDetails user = User
//                .withUsername("marco")
//                .password(passwordEncoder.encode("compusafe"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//
//
//}
//
