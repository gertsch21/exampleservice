package org.omilab.services.exampleservice.service;

import org.omilab.services.exampleservice.model.LogMessage;
import org.omilab.services.exampleservice.model.Page;
import org.omilab.services.exampleservice.repo.InstanceRepository;
import org.omilab.services.exampleservice.repo.PageRepository;
import org.omilab.services.exampleservice.repo.PostRepository;
import org.omilab.services.exampleservice.service.logging.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("AdminService")
@Transactional
public final class AdminServiceImpl implements AdminService {

	private final PageRepository pageRepo;
	private final InstanceRepository instanceRepo;
	private final LoggingService logService;

	@Autowired
	public AdminServiceImpl(final PageRepository pageRepo, final InstanceRepository instanceRepo, final LoggingService logService) {
		this.pageRepo = pageRepo;
		this.instanceRepo = instanceRepo;
		this.logService = logService;
	}

	public void processChange(final String content, final Long id, final String endpoint, final String user) {
		if(pageRepo.findByInstanceAndEndpoint(id,endpoint) == null) {
			pageRepo.save(new Page(endpoint,content,instanceRepo.findById(id)));
			logService.logMessage(new LogMessage(user,"create","Page",id.toString()));
		}
		else {
			pageRepo.findByInstanceAndEndpoint(id,endpoint).setContent(content);
			logService.logMessage(new LogMessage(user,"update","Page",id.toString()));
		}
	}
}
