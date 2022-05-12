package com.example.hrmsbackend.core.business.abstracts;

import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.Result;

import java.util.List;

public interface BaseService<T, Id> {
	Result add(T entity);

	Result delete(Id id);

	DataResult<List<T>> getAll();

	DataResult<T> getById(Id id);

	Result update(T entity);
}
