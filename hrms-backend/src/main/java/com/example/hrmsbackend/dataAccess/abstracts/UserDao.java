package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
