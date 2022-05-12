package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.MernisActivationService;
import com.example.hrmsbackend.business.adapters.mernisService.PersonForValidateFromMernisService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.utilities.results.Result;
import com.example.hrmsbackend.core.utilities.results.SuccessResult;
import com.example.hrmsbackend.dataAccess.abstracts.MernisActivationDao;
import com.example.hrmsbackend.entities.concretes.MernisActivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MernisActivationManager extends BaseManager<MernisActivationDao, MernisActivation, Integer>
		implements MernisActivationService {
	private final MernisActivationDao mernisActivationDao;

	@Autowired
	public MernisActivationManager(final MernisActivationDao mernisActivationDao) {
		super(mernisActivationDao, "Mernis activation");
		this.mernisActivationDao = mernisActivationDao;
	}

	@Override
	public Result check(final PersonForValidateFromMernisService personForValidateFromMernisService) {
		// TODO Validate with Mernis System Adapter
		return new SuccessResult(Messages.verified("Mernis activation"));
	}
}
