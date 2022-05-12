package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.EmailActivationService;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.dtos.EmailActivationForVerifyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/emailactivations")
public class EmailActivationsController {
	private final EmailActivationService emailActivationService;

	@Autowired
	public EmailActivationsController(final EmailActivationService emailActivationService) {
		this.emailActivationService = emailActivationService;
	}

	@GetMapping("/verify")
	public ResponseEntity<Result> verify(@Valid final EmailActivationForVerifyDto emailActivationForVerifyDto) {
		final Result result = emailActivationService.verify(emailActivationForVerifyDto);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}
