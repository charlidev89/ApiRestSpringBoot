package com.chalie.apirest.api.repository;

import com.chalie.apirest.api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Long> {  // el repository trabajara con entidades company y con id Long

}