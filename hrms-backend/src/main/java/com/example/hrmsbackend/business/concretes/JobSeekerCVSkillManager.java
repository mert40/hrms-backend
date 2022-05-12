package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVSkillService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.SuccessDataResult;
import com.example.hrmsbackend.dataAccess.abstracts.JobSeekerCVSkillDao;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerCVSkillManager extends BaseManager<JobSeekerCVSkillDao, JobSeekerCVSkill, Integer>
		implements JobSeekerCVSkillService {
	private final JobSeekerCVSkillDao jobSeekerCVSkillDao;

	@Autowired
	public JobSeekerCVSkillManager(final JobSeekerCVSkillDao jobSeekerCVSkillDao) {
		super(jobSeekerCVSkillDao, "Job seeker CV skill");
		this.jobSeekerCVSkillDao = jobSeekerCVSkillDao;
	}

	@Override
	public DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVSkill> jobSeekerCVSkills = jobSeekerCVSkillDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVSkills);
	}

}
