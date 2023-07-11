package com.mansour.thymeleafcrud.daos;

import com.mansour.thymeleafcrud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface ThymeleafCrudDAO extends JpaRepository<User, Integer> {
}
