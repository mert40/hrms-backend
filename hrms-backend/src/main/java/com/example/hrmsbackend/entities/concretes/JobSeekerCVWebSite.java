package com.example.hrmsbackend.entities.concretes;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "job_seeker_cv_web_sites")
public class JobSeekerCVWebSite {
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
    @JoinColumn(name = "web_site_id")
    @ManyToOne
    private WebSite webSite;

    @NotBlank
    @Length(max = 200)
    @Column(name = "address")
    private String address;
}
