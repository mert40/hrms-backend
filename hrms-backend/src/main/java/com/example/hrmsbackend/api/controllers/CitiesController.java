package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.CityService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController extends BaseController<CityService, City, Short> {
	private final CityService cityService;

	@Autowired
	public CitiesController(final CityService cityService) {
		super(cityService);
		this.cityService = cityService;
	}

	@GetMapping("/byname")
	public ResponseEntity<DataResult<City>> getByName(final String name) {
		final DataResult<City> result = cityService.getByName(name);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/bynamecontains")
	public ResponseEntity<DataResult<List<City>>> getByNameContains(final String name) {
		final DataResult<List<City>> result = cityService.getByNameContains(name);

		return ResponseEntity.ok(result);
	}
}
