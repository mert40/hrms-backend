package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.JobSeekerCVImageService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.entities.Image;
import com.example.hrmsbackend.core.utilities.helpers.image.ImageService;
import com.example.hrmsbackend.core.utilities.helpers.image.cloudinary.CloudinaryImageHelper;
import com.example.hrmsbackend.core.utilities.results.*;
import com.example.hrmsbackend.dataAccess.abstracts.JobSeekerCVImageDao;
import com.example.hrmsbackend.entities.concretes.JobSeekerCVImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerCVImageManager extends BaseManager<JobSeekerCVImageDao, JobSeekerCVImage, Integer>
		implements JobSeekerCVImageService {
	private final JobSeekerCVImageDao jobSeekerCVImageDao;
	private final ImageService imageService;

	@Autowired
	public JobSeekerCVImageManager(final JobSeekerCVImageDao jobSeekerCVImageDao, final ImageService imageService) {
		super(jobSeekerCVImageDao, "Job seeker CV image");
		this.jobSeekerCVImageDao = jobSeekerCVImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result addAndSave(final JobSeekerCVImage jobSeekerCVImage, final MultipartFile file) {
		final Image result = imageService.save(file).getData();
		jobSeekerCVImage.setUrl(result.getUrl());

		return super.add(jobSeekerCVImage);
	}

	@Override
	public Result delete(final Integer id) {
		final Optional<JobSeekerCVImage> jobSeekerCVImage = jobSeekerCVImageDao.findById(id);
		if (jobSeekerCVImage.isEmpty())
			return new ErrorDataResult<JobSeekerCVImage>(
					com.example.hrmsbackend.core.business.constants.Messages.deleted("Job seeker CV image"));

		final var imagePublicId = CloudinaryImageHelper.getImagePublicIdFromUrl(jobSeekerCVImage.get().getUrl());
		imageService.delete(imagePublicId);

		jobSeekerCVImageDao.delete(jobSeekerCVImage.get());
		return new SuccessResult(Messages.deleted("Job seeker CV Image"));
	}

	@Override
	public DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVImage> jobSeekerCVImages = jobSeekerCVImageDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVImages);
	}
}