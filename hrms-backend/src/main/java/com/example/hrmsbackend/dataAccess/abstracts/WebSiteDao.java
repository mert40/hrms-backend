package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebSiteDao extends JpaRepository<WebSite, Short> {
	Optional<WebSite> findByName(String name);
}
