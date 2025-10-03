package com.dominar01.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominar01.demo.Service.UserService;
import com.dominar01.demo.model.User;
import com.dominar01.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public User crearUsuarios(User user) {
        return repo.save(user);
    }

    @Override
    public User actualizarUsuarios(Integer id, User user) {
        return repo.update(id, user);
    }

    @Override
    public User obtenerPorId(Integer id) {
        return repo.findById(id);
    }

    @Override
    public void eliminarUsuarios(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<User> listarTodosUsuarios() {
        return repo.findAll();
    }
    
}
