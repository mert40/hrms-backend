package com.example.hrmsbackend.core.utilities.business;

import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.core.utilities.results.SuccessResult;

public class BusinessRules {
	public static Result run(final Result... logics) {
		for (final Result logic : logics)
			if (!logic.isSuccess())
				return logic;
		return new SuccessResult();
	}
}
