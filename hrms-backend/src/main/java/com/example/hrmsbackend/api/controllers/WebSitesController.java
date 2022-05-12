package com.example.hrmsbackend.api.controllers;

import com.example.hrmsbackend.business.abstracts.WebSiteService;
import com.example.hrmsbackend.core.api.abstracts.BaseController;
import com.example.hrmsbackend.entities.concretes.WebSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/websites")
public class WebSitesController extends BaseController<WebSiteService, WebSite, Short> {
	@Autowired
	public WebSitesController(final WebSiteService webSiteService) {
		super(webSiteService);
	}
}
