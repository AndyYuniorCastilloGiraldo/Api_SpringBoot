package com.dominar01.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominar01.demo.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
    
    //Book getBookById(int id);

    
}
