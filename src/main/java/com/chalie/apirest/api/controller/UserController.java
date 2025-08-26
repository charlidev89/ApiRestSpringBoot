package com.chalie.apirest.api.controller;

import com.chalie.apirest.api.model.User;
import com.chalie.apirest.api.model.UserRole;
import com.chalie.apirest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")  //Uri del controller
public class UserController {  //Controlador maneja las request y responses

    @Autowired
    private UserService userService;

    @PostMapping
    public User crearUser(@RequestBody User user) {
        return userService.crearUsuario(user);   // llamamos al metodo de Service
    }

    @GetMapping
    public List<User> obtenerTodos() {
        return userService.obtenerTodosLosUsers();
    }

    @GetMapping("{id}")
    public User obtenerUserPorId(@PathVariable("id") Long id) {
        return userService.obtenerUserPorId(id);

    }

    @DeleteMapping("{id}")
    public void eliminarUserPorId(@PathVariable("id") Long id) {
        userService.eliminarUserPorId(id);
    }
    // metodo agregado ob tener usuarios  por company
    @GetMapping("/company/{companyId}")
    public List<User> obtenerUsersPorCompany(@PathVariable("companyId") Long companyId) {
        return userService.obtenerUsersPorCompany(companyId);
    }
    // metodo nuevo  obtener usuarios por rol
    @GetMapping("/role/{role}")
    public List<User> obtenerUsersPorRole(@PathVariable("role") UserRole role) {
        return userService.obtenerUsersPorRole(role);
    }



}
