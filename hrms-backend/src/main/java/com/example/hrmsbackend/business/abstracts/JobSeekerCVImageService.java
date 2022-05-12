package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobSeekerCVImageService extends BaseService<JobSeekerCVImage, Integer> {
	Result addAndSave(JobSeekerCVImage jobSeekerImage, MultipartFile file);

	DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
