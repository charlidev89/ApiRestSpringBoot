package com.chalie.apirest.api.service;

import com.chalie.apirest.api.model.Company;
import com.chalie.apirest.api.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Component
public class CompanyService {

    @Autowired
    private ICompanyRepository companyRepository;

    public Company crearCompania(Company company) {
        return companyRepository.save(company);
    }

    public Company obtenerCompaniaPorId(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);  // utilizamos optional para manejar mejor los objetos tipo null
        return optionalCompany.orElseThrow(() ->
                new RuntimeException("Compania no encontrada con ID : " + id));  // manejamos el error con runtime exception  lanzando un mensaje personalizado
    }

    public List<Company> obtenerTodasLasCompanias() {
        List<Company> companies = companyRepository.findAll();

        if (companies.isEmpty()) {
            throw new NoSuchElementException("No existen compañías en el sistema");
        }

        return companies;
    }

    public void eliminarCompaniaPorId(Long id) {

        if (!companyRepository.existsById(id)) {
            throw new IllegalArgumentException("Company con ID " + id + " no valido");
        }
        companyRepository.deleteById(id);

    }

}
