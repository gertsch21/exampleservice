package org.omilab.services.exampleservice.service;

import org.omilab.services.exampleservice.model.Topic;

import java.util.Set;

/**
 * Created by omilab on 15/01/17.
 */

public interface TopicMgmtService {

    public void createTopic (String name);

    public Set<Topic> getTopics( );

    public Topic getTopicByName(String name);
}
