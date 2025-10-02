package com.dominar01.demo.Service;

import java.util.List;

import com.dominar01.demo.model.Category;

public interface CategoryService {
    
    //Category validAndReturnCategory(int id);
    Category guardar(Category category);
    Category actualizar(Integer id, Category category);
    List<Category> findAll();
    Category findById(Integer id);
    void delete(Integer id);
}
