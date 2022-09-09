package com.example.spring_boot_training.controller;

import com.example.spring_boot_training.user.UserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @GetMapping
    public UserDetails user(@AuthenticationPrincipal UserDetails userDetails){
        return userDetails;
    }
}
