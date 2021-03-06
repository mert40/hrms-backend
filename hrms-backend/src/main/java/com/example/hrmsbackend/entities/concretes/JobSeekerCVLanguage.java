package com.example.hrmsbackend.entities.concretes;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "job_seeker_cv_languages")
public class JobSeekerCVLanguage {
    @NotNull
    @Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @JoinColumn(name = "job_seeker_cv_id")
    @ManyToOne
    private JobSeekerCV jobSeekerCV;

    @NotNull
    @JoinColumn(name = "language_id")
    @ManyToOne
    private Language language;

    @NotNull
    @Range(min = 1, max = 6)
    @Column(name = "level")
    private short level;
}