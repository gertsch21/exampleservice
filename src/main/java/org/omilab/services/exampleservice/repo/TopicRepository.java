package org.omilab.services.exampleservice.repo;

import org.omilab.services.exampleservice.model.Post;
import org.omilab.services.exampleservice.model.Topic;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by omilab on 14/01/17.
 */
public interface TopicRepository extends Repository<Topic, Long> {

    @Modifying
    @Transactional
    Topic save(Topic topic);

    @Query("select t from Topic t where t.topicId = ?1")
    Topic findTopicByTopicId(long topicId);

    @Query("select t from Topic AS t")
    Set<Topic> getTopics();


}
