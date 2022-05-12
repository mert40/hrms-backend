package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.EmailActivation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailActivationDao extends JpaRepository<EmailActivation, Integer> {
	Optional<EmailActivation> findByEmailAndActivationCode(String email, String activationCode);
}
