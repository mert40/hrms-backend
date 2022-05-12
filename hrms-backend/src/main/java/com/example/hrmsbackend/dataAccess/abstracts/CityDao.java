package com.example.hrmsbackend.dataAccess.abstracts;

import com.example.hrmsbackend.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CityDao extends JpaRepository<City, Short> {
	Optional<City> findByName(String name);

	Optional<List<City>> findByNameContains(String name);
}
