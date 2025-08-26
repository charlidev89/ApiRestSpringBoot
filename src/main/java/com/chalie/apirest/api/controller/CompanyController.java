package com.chalie.apirest.api.controller;

import com.chalie.apirest.api.model.Company;
import com.chalie.apirest.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company crearCompany(@RequestBody Company company) {
        return companyService.crearCompania(company);
    }

    @GetMapping
    public List<Company> obtenerTodas() {
        return companyService.obtenerTodasLasCompanias();
    }

    @GetMapping("{id}")
    public Company obtenerCompanyPorId(@PathVariable("id") Long id) {
        return companyService.obtenerCompaniaPorId(id);
    }

    @DeleteMapping("{id}")
    public void eliminarCompanyPorId(@PathVariable("id") Long id) {
        companyService.eliminarCompaniaPorId(id);
    }
}