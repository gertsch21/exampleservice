package org.omilab.services.exampleservice.repo;

import org.omilab.services.exampleservice.model.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface PageRepository extends Repository<Page, Long> {

	Page findById(Long id);

	@Query("select p from Page p join p.instance i where i.id=?1 and p.endpoint=?2")
	public Page findByInstanceAndEndpoint(Long id, String endpoint);

	Page save(Page p);

}
