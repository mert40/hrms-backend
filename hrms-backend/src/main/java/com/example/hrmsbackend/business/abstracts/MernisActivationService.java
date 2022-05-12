package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.business.adapters.mernisService.PersonForValidateFromMernisService;
import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.entities.concretes.MernisActivation;

public interface MernisActivationService extends BaseService<MernisActivation, Integer> {
	Result check(PersonForValidateFromMernisService personForValidateFromMernisService);
}