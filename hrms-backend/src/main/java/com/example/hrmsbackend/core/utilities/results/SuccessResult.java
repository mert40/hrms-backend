package com.example.hrmsbackend.core.utilities.results;

public class SuccessResult extends Result {
	public SuccessResult() {
		super(true);
	}

	public SuccessResult(final String message) {
		super(true, message);
	}
}