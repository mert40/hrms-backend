package com.example.hrmsbackend.core.utilities.helpers.email;

import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result send(final String to, final String title, final String body) {
		// TODO
		return new SuccessResult("Email has send.");
	}

}
