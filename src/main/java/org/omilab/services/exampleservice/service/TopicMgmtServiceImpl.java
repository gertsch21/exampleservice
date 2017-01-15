package org.omilab.services.exampleservice.service;

import org.omilab.services.exampleservice.model.Topic;
import org.omilab.services.exampleservice.repo.InstanceRepository;
import org.omilab.services.exampleservice.repo.PostRepository;
import org.omilab.services.exampleservice.repo.TopicRepository;
import org.omilab.services.exampleservice.service.logging.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by omilab on 15/01/17.
 */

@Component("TopicMgmtService")
@Transactional
public class TopicMgmtServiceImpl implements TopicMgmtService {

    private final TopicRepository topicRepo;

    @Autowired
    public TopicMgmtServiceImpl(final TopicRepository topicRepo)  {

        this.topicRepo = topicRepo;
    }

    @Override
    public void createTopic(String name) {
        topicRepo.save( new Topic(name) );
    }

    @Override
    public Set<Topic> getTopics(){ return topicRepo.getTopics();}

    @Override
    public Topic getTopicByName(String name){return topicRepo.findTopicByName(name);}
}
