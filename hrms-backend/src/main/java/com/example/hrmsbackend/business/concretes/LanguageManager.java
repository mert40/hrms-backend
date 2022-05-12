package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.LanguageService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.dataAccess.abstracts.LanguageDao;
import com.example.hrmsbackend.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager extends BaseManager<LanguageDao, Language, String> implements LanguageService {
	@Autowired
	public LanguageManager(final LanguageDao languageDao) {
		super(languageDao, "Language");
	}
}
