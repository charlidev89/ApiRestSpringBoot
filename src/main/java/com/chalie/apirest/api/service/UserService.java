package com.chalie.apirest.api.service;

import com.chalie.apirest.api.model.User;
import com.chalie.apirest.api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {  // En service creamos metodos CRUD , se pueden usar o no interfaces (Solid)

    // inyectamos dependencia ala variable
    @Autowired
    private IUserRepository userRepository;

    //creamos los metodos

    public User crearUsuario(User user) {
        return userRepository.save(user);  //metodo save de JPA de Repository
    }

    public User obtenerUserPorId(Long id) {
        //Optional es una clase  de contenedor que se usa para manejar los objetos nulos evita errones comunes como
        //NullPointerException    puede retornar el User o un empty
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            // Manejo del caso en que no se encuentra el usuario
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public List<User> obtenerTodosLosUsers() {
        return userRepository.findAll();

    }

    public void eliminarUserPorId(Long id) {
        userRepository.deleteById(id);
    }


}
