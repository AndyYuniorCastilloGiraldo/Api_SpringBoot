package com.dominar01.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dominar01.demo.Service.UserService;
import com.dominar01.demo.model.User;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User crear(@RequestBody User user) {
        return service.crearUsuarios(user);
    }

    @PutMapping("/{id}")
    public User actualizar(@PathVariable Integer id, @RequestBody User user) {
        return service.actualizarUsuarios(id, user);
    }

    @GetMapping("/{id}")
    public User obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminarUsuarios(id);
    }

    @GetMapping
    public List<User> listar() {
        return service.listarTodosUsuarios();
    }
}
