package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.MernisActivation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MernisActivationDao extends JpaRepository<MernisActivation, Integer> {
	Optional<MernisActivation> findByUserId(int userId);
}