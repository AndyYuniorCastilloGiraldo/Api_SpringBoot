package com.dominar01.demo.Service;

import java.util.List;

import com.dominar01.demo.model.User;
public interface UserService {
    
    User crearUsuarios(User user);
    User actualizarUsuarios(Integer id, User user);
    User obtenerPorId(Integer id);
    void eliminarUsuarios(Integer id);
    List<User> listarTodosUsuarios();
    
}
