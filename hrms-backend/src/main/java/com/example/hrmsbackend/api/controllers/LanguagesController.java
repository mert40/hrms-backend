package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.LanguageService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController extends BaseController<LanguageService, Language, String> {

	@Autowired
	public LanguagesController(final LanguageService languageService) {
		super(languageService);
	}
}
