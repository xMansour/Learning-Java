package com.mansour.springbootcrud.dao;

import com.mansour.springbootcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface UserJPARepository extends JpaRepository<User, Integer> {
}
