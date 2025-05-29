package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.bookservice;

@RestController
public class bookcont {

    @Autowired
    private bookservice bookservice;

    @GetMapping("/books")
    public List<Book> getall(){
        return bookservice.findallbooks();
    }

    @GetMapping("/{id}")
    public Book getbook(@PathVariable Long id){
        return bookservice.findbyidbook(id);
    }

    @PostMapping("/books")
    public Book createbooks(@RequestBody Book b){
        return bookservice.updatebook(b);
    }

    @PutMapping("/{id}")
    public Book updatebook(@PathVariable Long id,@RequestBody Book bd){
        Book ex=bookservice.findbyidbook(id);
        ex.setTitle(bd.getTitle());
        ex.setAuthor(bd.getAuthor());
        return bookservice.updatebook(ex);
    }

    @DeleteMapping("/{id}")
    public void deletebook(@PathVariable Long id){
        bookservice.deletebookbyid(id);
    }
    



}
