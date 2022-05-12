package com.example.hrmsbackend.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdverts" })
@Entity
@Table(name = "working_times")
public class WorkingTime {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@NotBlank
	@Length(max = 50)
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "workingTime")
	private List<JobAdvert> jobAdverts;
}
