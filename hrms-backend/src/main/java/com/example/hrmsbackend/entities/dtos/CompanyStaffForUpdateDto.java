package com.example.hrmsbackend.entities.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class CompanyStaffForUpdateDto {
	@NotNull
	private int id;

	@NotBlank
	@Size(max = 50)
	private String firstName;

	@NotBlank
	@Size(max = 50)
	private String lastName;

	@NotBlank
	@Size(max = 100)
	private String password;
}
