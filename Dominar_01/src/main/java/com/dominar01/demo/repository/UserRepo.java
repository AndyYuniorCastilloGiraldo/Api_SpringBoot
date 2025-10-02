package com.dominar01.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominar01.demo.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer> {
    
    //SELECT * FROM user_info WHERE username = 'andy'
    UserInfo findByUsername(String username);
    
}
