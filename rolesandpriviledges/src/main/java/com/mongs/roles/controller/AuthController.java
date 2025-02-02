package com.mongs.roles.controller;

import com.mongs.roles.MyUserDetailsService;
import com.mongs.roles.User;
import com.mongs.roles.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private MyUserDetailsService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto user) {
        try{
            User registeredUser = userService.register(user);
            return ResponseEntity.ok("User registered successfully");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("User registration failed");
        }
    }
}
