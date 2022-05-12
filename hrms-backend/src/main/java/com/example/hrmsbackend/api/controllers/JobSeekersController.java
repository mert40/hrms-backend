package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.JobSeekerService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.concretes.JobSeeker;
import com.example.hrmsbackend.entities.concretes.JobSeekersFavoriteJobAdvert;
import com.example.hrmsbackend.entities.dtos.JobSeekerForRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController extends BaseController<JobSeekerService, JobSeeker, Integer> {
	private final JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(final JobSeekerService jobSeekerService) {
		super(jobSeekerService);
		this.jobSeekerService = jobSeekerService;
	}

	@PostMapping("/register")
	public ResponseEntity<Result> register(@Valid @RequestBody final JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		final Result result = jobSeekerService.register(jobSeekerForRegisterDto);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@GetMapping({ "/favorite/jobadvert/byjobseekeridandjobadvertid" })
	public ResponseEntity<DataResult<JobSeekersFavoriteJobAdvert>> getByJobSeekerIdAndJobAdvertId(
			@RequestParam final int jobSeekerId, @RequestParam final int jobAdvertId) {
		DataResult<JobSeekersFavoriteJobAdvert> result = this.jobSeekerService
				.getFavoriteByJobSeekerIdAndJobAdvertId(jobSeekerId, jobAdvertId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PostMapping({ "/favorite/jobadvert" })
	public ResponseEntity<Result> favoriteJobAdvert(
			@RequestBody final JobSeekersFavoriteJobAdvert jobSeekersFavoriteJobAdvert) {
		Result result = this.jobSeekerService.favoriteJobAdvert(jobSeekersFavoriteJobAdvert);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping({ "/favorite/jobadvert" })
	public ResponseEntity<Result> undoFavoriteJobAdvert(@RequestParam final int jobSeekersFavoriteJobAdvertId) {
		Result result = this.jobSeekerService.undoFavoriteJobAdvert(jobSeekersFavoriteJobAdvertId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}
