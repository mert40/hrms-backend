package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.EmployerService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.concretes.Employer;
import com.example.hrmsbackend.entities.concretes.EmployerUpdate;
import com.example.hrmsbackend.entities.dtos.EmployerForRegisterDto;
import com.example.hrmsbackend.entities.dtos.EmployerForUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController extends BaseController<EmployerService, Employer, Integer> {
	private final EmployerService employerService;

	@Autowired
	public EmployersController(final EmployerService employerService) {
		super(employerService);
		this.employerService = employerService;
	}

	@GetMapping("/update/byuserid/last")
	public ResponseEntity<DataResult<EmployerUpdate>> getLastUpdateByUserId(@RequestParam final int employerId) {
		final DataResult<EmployerUpdate> result = employerService.getLastUpdateByUserId(employerId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/update/byisapprovedandisdeleted")
	public ResponseEntity<DataResult<List<EmployerUpdate>>> getAllByIsApprovedAndIsDeleted(
			@RequestParam final boolean isApproved,
			@RequestParam final boolean isDeleted) {
		final DataResult<List<EmployerUpdate>> result = employerService.getAllByIsApprovedAndIsDeleted(isApproved,
				isDeleted);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/register")
	public ResponseEntity<Result> register(@Valid @RequestBody final EmployerForRegisterDto employerForRegisterDto) {
		final Result result = employerService.register(employerForRegisterDto);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/byuser")
	public ResponseEntity<Result> updateByUser(@Valid @ModelAttribute EmployerForUpdateDto employerForUpdateDto,
			@RequestBody MultipartFile companyImage) {
		final Result result = employerService.updateByUser(employerForUpdateDto, companyImage);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/verify/update")
	public ResponseEntity<Result> verifyUpdate(@RequestParam final int employerUpdateId) {
		final Result result = employerService.verifyUpdate(employerUpdateId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/deny/update")
	public ResponseEntity<Result> denyUpdate(@RequestParam final int employerUpdateId) {
		final Result result = employerService.denyUpdate(employerUpdateId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}