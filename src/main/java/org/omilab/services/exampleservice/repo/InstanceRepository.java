package org.omilab.services.exampleservice.repo;

import org.omilab.services.exampleservice.model.Instance;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface InstanceRepository extends Repository<Instance, Long> {

	@Modifying
	@Transactional
	void deleteById(Long id);

	Instance findById(Long id);

	@Query("select i.id from Instance i where i.psmip=?1")
	List<Long> findByPsmip(String psmip);

	Instance save(Instance i);

}
