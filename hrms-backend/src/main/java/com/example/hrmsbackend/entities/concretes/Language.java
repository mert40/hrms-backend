package com.example.hrmsbackend.entities.concretes;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "languages")
public class Language {
	@NotBlank
	@Size(min = 2, max = 2)
	@Column(name = "id")
	@Id
	private String id;

	@NotBlank
	@Size(max = 50)
	@Column(name = "name")
	private String name;
}
