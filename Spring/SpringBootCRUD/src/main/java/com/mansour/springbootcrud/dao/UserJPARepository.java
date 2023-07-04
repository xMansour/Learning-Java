package com.mansour.springbootcrud.dao;

import com.mansour.springbootcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Integer> {
}
