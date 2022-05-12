package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.WorkingType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTypeDao extends JpaRepository<WorkingType, Short> {
}
