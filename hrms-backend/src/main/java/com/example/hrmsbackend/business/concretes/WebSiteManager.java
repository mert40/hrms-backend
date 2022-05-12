package com.example.hrmsbackend.business.concretes;

import com.example.hrmsbackend.business.abstracts.WebSiteService;
import com.example.hrmsbackend.core.business.abstracts.BaseManager;
import com.example.hrmsbackend.core.business.constants.Messages;
import com.example.hrmsbackend.core.utilities.results.DataResult;
import com.example.hrmsbackend.core.utilities.results.ErrorDataResult;
import com.example.hrmsbackend.core.utilities.results.SuccessDataResult;
import com.example.hrmsbackend.dataAccess.abstracts.WebSiteDao;
import com.example.hrmsbackend.entities.concretes.WebSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebSiteManager extends BaseManager<WebSiteDao, WebSite, Short> implements WebSiteService {
	private final WebSiteDao webSiteDao;

	@Autowired
	public WebSiteManager(final WebSiteDao webSiteDao) {
		super(webSiteDao, "Website");
		this.webSiteDao = webSiteDao;
	}

	@Override
	public DataResult<WebSite> getByName(final String name) {
		final Optional<WebSite> webSite = webSiteDao.findByName(name);

		if (webSite.isEmpty()) {
			return new ErrorDataResult<>(Messages.notFound("A user with the mail"));
		}

		return new SuccessDataResult<>(webSite.get());
	}
}
