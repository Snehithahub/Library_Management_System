package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.User;
import com.example.demo.service.userservice;

public class usercontr {
    
    @Autowired
    private userservice userservice;

    @GetMapping("/users")
    public List<User> getall(){
        return userservice.findallusers();
    }

    @PostMapping("/users")
    public User createbooks(@RequestBody User u){
        return userservice.updateuser(u);
    }

}
