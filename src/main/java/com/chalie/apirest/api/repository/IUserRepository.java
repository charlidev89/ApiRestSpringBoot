package com.chalie.apirest.api.repository;

import com.chalie.apirest.api.model.User;
import com.chalie.apirest.api.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository <User,Long> {
    List<User> findByCompanyId(Long companyId);
    List<User> findByRole(UserRole role);
}
