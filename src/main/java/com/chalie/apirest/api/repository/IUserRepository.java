package com.chalie.apirest.api.repository;

import com.chalie.apirest.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository <User,Long> {

}
