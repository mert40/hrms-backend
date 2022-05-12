package com.example.hrmsbackend.business.abstracts;

import com.example.hrmsbackend.core.business.abstracts.BaseService;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.entities.concretes.WebSite;

public interface WebSiteService extends BaseService<WebSite, Short> {
	DataResult<WebSite> getByName(String name);
}
