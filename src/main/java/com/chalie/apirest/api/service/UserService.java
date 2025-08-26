package com.chalie.apirest.api.service;

import com.chalie.apirest.api.model.Company;
import com.chalie.apirest.api.model.User;
import com.chalie.apirest.api.model.UserRole;
import com.chalie.apirest.api.repository.IUserRepository;
import com.chalie.apirest.api.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {  // En service creamos metodos CRUD , se pueden usar o no interfaces (Solid)

    // inyectamos dependencia ala variable
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICompanyRepository companyRepository;


    //creamos los metodos

    public User crearUsuario(User user) {
        // Validar que la compañía existe
        if (user.getCompany() == null || user.getCompany().getId() == null) {
            throw new RuntimeException("Company is required");
        }

        Company company = companyRepository.findById(user.getCompany().getId())
                .orElseThrow(() -> new RuntimeException("Company not found"));

        user.setCompany(company);

        // Restriccion de negocio
        if (user.getRole() == null) {
            user.setRole(UserRole.EMPLOYEE); // Rol por defecto
        }
        // Aquí se valida automáticamente que el rol sea uno de los valores del Enum

        return userRepository.save(user);
    }

    public User obtenerUserPorId(Long id) {
        //Se decide utilizar Optional para manejar los objetos nulos  y asi evitar errones comunes como
        //NullPointerException  :  puede retornar el User o un empty
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

    // metodo nuevo obtener usuarios por company
    public List<User> obtenerUsersPorCompany(Long companyId) {
        // Validar que la compañía existe
        if (!companyRepository.existsById(companyId)) {
            throw new RuntimeException("Compania no encontrada por id: " + companyId);
        }
        return userRepository.findByCompanyId(companyId);
    }

    // Obtener users por rol
    public List<User> obtenerUsersPorRole(UserRole role) {
        return userRepository.findByRole(role);
    }


}
