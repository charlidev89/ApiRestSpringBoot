package com.chalie.apirest.api.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // indica que el valor de id debe ser generado automáticamente por la base de datos usando la estrategia IDENTITY.
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
}
