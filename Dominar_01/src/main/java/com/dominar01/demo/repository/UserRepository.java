package com.dominar01.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.dominar01.demo.model.User;

@Repository
public interface UserRepository{
    
    User save(User user);
    User update(Integer id, User user);
    User findById(Integer id);
    void deleteById(Integer id);
    List<User> findAll();
}
