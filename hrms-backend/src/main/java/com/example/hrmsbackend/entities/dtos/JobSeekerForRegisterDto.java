package com.example.hrmsbackend.entities.dtos;

import com.example.hrmsbackend.core.entities.Dto;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class JobSeekerForRegisterDto implements Dto {
	//@NotBlank
	@Email
	@Size(max = 100)
	private String email;

	//@NotBlank
	@Size(max = 100)
	private String password;

	//@NotBlank
	@Size(max = 100)
	private String confirmPassword;

	//@NotBlank
	private String firstName;

	//@NotBlank
	private String lastName;

	//@NotBlank
	@Size(min = 11, max = 11)
	private String identityNumber;

	//@NotNull
	@Past
	private LocalDate birthDate;
}
