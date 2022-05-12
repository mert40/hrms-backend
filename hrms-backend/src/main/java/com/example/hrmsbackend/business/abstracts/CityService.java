package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.City;

import java.util.List;

public interface CityService extends BaseService<City, Short> {
	DataResult<City> getByName(String name);

	DataResult<List<City>> getByNameContains(String name);
}
