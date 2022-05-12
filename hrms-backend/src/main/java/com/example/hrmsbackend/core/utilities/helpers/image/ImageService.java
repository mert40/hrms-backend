package com.example.hrmsbackend.core.utilities.helpers.image;

import com.example.hrmsbackend.core.entities.Image;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.Result;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	DataResult<Image> save(MultipartFile file);

	Result delete(String id);
}
