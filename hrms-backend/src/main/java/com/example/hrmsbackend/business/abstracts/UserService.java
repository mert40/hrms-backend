package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.entities.User;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.Result;

public interface UserService extends BaseService<User, Integer> {
	DataResult<User> getByEmail(String email);

	Result isNotEmailExist(final String email);
}
