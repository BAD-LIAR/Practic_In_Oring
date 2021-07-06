package com.example.webservice.repository;

import com.example.webservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
}
