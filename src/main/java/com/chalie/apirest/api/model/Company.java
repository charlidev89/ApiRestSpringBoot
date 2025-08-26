package com.chalie.apirest.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity   // determinamos que la clase es una entidad
@Data   //anotación de Lombok que genera getters, setters, toString, equals, hashCode y constructor sin args
@Table(name = "companies")  // indica que esta clase pertenece a la tabla con el nombre companies
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // crea de forma secuencial el id , es ideal para Mysql
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String address;
    private String phone;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // cascade: las operaciones se propagan automáticamente a los usuarios relacionados
    // fetch: carga perezosa para mejor performance (solo carga usuarios cuando se accede a la colección)
    private List<User> users = new ArrayList<>();


}
