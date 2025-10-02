package com.dominar01.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominar01.demo.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    
    //Book getBookById(int id);

    
}