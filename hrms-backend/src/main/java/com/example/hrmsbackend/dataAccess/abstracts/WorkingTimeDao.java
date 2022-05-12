package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeDao extends JpaRepository<WorkingTime, Short> {
}
