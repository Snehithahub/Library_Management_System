package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.userrepo;

@Service
public class userservice {
    
    @Autowired
    private userrepo userrepo;

    public List<User> findallusers(){
        return userrepo.findAll();
    }

    public User updateuser(User u){
        return userrepo.save(u);
    }

}
