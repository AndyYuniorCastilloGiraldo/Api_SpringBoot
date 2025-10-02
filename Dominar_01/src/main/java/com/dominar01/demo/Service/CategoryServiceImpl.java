package com.dominar01.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dominar01.demo.model.Category;
import com.dominar01.demo.repository.CategoryRepo;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryRepo repo;

    @Override
    public Category guardar(Category category) {
        // TODO Auto-generated method stub
       return repo.save(category);
    }

    @Override
    public Category actualizar(Integer id, Category category) {
        // TODO Auto-generated method stub
        category.setIdCategory(id);
        return repo.save(category);
    }

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public Category findById(Integer id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElse(new Category(999,"NO CATEGORY"));
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }

}
