package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.entities.User;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.dtos.EmailActivationForVerifyDto;
import com.example.hrmsbackend.entities.concretes.EmailActivation;

public interface EmailActivationService extends BaseService<EmailActivation, Integer> {
	Result createAndSendActivationCodeByMail(User user, String... emails);

	Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto);
}
