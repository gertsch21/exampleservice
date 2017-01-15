package org.omilab.services.exampleservice.service;

import org.omilab.services.exampleservice.model.Instance;
import org.omilab.services.exampleservice.repo.InstanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;


@Component("InstanceMgmtService")
@Transactional
@SuppressWarnings("unused")
public final class InstanceMgmtServiceImpl implements InstanceMgmtService {

	private static final Logger logger = LoggerFactory.getLogger(InstanceMgmtServiceImpl.class);

	private final InstanceRepository instanceRepo;

	@Autowired
	public InstanceMgmtServiceImpl(InstanceRepository instanceRepo) {
		this.instanceRepo = instanceRepo;
	}

	@Override
	public Long createInstance(final String psmip) {
		final Instance i = instanceRepo.save(new Instance(psmip));
		if(i == null) {
			logger.warn("Failed to save instance with url: " + psmip);
			return 0L;
		} else {
			logger.info("Sucessfully created instance with id: " + i.getId());
			return i.getId();
		}
	}

	@Override
	public Boolean deleteInstance(Long instance) {
		System.out.println("Deleting everything with the instance " + instance);
		try {
			instanceRepo.deleteById(instance);
		} catch(Exception e) {
			logger.error("Failed to remove instance with id: " + instance, e);
			return false;
		}
		logger.info("Sucessfully removed instance with id: " + instance);
		return true;
	}

	@Override
	public Boolean checkAccess(final String ip, final Long id) {
		if(instanceRepo.findByPsmip(ip).contains(id))
			return true;
		return false;
	}
}