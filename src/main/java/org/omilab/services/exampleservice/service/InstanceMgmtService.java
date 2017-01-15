package org.omilab.services.exampleservice.service;

public interface InstanceMgmtService {

	public Long createInstance(String psmip);

	public Boolean deleteInstance(Long instance);

	public Boolean checkAccess(String ip, Long id);

}