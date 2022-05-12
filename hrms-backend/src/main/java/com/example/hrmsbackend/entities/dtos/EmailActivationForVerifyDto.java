package com.example.hrmsbackend.entities.dtos;

import com.example.hrmsbackend.core.entities.Dto;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class EmailActivationForVerifyDto implements Dto {
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String activationCode;