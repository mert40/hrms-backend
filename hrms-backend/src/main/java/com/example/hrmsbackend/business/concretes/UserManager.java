package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.UserService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.entities.User;
import com.example.hrmsbackend.core.utilities.results.*;
import com.example.hrmsbackend.dataAccess.abstracts.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager extends BaseManager<UserDao, User, Integer> implements UserService {
	private final UserDao userDao;

	@Autowired
	public UserManager(final UserDao userDao) {
		super(userDao, "User");
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getByEmail(final String email) {
		final Optional<User> user = userDao.findByEmail(email);

		if (user.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("User"));

		return new SuccessDataResult<>(user.get());
	}

	@Override
	public Result isNotEmailExist(final String email) {
		return userDao.findByEmail(email).isEmpty() ? new SuccessResult()
				: new ErrorResult(Messages.verified("A user with the mail"));
	}
}
