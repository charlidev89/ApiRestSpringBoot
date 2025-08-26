package com.chalie.apirest.api.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;


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
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private UserRole role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "company_id" , nullable = false)
    private Company company;



}
