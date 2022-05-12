package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.CityService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.ErrorDataResult;
import com.example.hrmsbackend.core.utilities.results.SuccessDataResult;
import com.example.hrmsbackend.dataAccess.abstracts.CityDao;
import com.example.hrmsbackend.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityManager extends BaseManager<CityDao, City, Short> implements CityService {
	private final CityDao cityDao;

	@Autowired
	public CityManager(final CityDao cityDao) {
		super(cityDao, "City");
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<City> getByName(final String name) {
		final Optional<City> city = cityDao.findByName(name);

		if (city.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("City"));

		return new SuccessDataResult<>(city.get());
	}

	@Override
	public DataResult<List<City>> getByNameContains(final String name) {
		final Optional<List<City>> city = cityDao.findByNameContains(name);

		return new SuccessDataResult<>(city.get());
	}
}
