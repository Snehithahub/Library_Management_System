package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.repository.bookrepo;
import com.example.demo.repository.userrepo;

@Service
public class bookservice {

    @Autowired
    private bookrepo bookrepo;

    @Autowired
    private userrepo userrepo; 

    public List<Book> findallbooks(){
        return bookrepo.findAll();
    }

    public Book findbyidbook(Long id){
        return bookrepo.findById(id).orElse(null);
    }

    public Book updatebook(Book book){
        return bookrepo.save(book);
    }

    public void deletebookbyid(Long id){
         bookrepo.deleteById(id);
    }

    public Book borrowedbook(Long bookId,Long userId){
        Book b=findbyidbook(bookId);
        User u=userrepo.findById(userId).orElse(null);
        if(b !=null && u !=null && !b.isBorrowed()){
            b.setBorrowedBy(u);
            b.setBorrowed(true);
            return updatebook(b);
        }
        
        return null;
    }

    public Book returnbok(Long id){
        Book b=findbyidbook(id);
        if(b!=null && b.isBorrowed()){
            b.setBorrowedBy(null);
            b.setBorrowed(false);
            return updatebook(b);
        }
        return null;

    }
    

}
