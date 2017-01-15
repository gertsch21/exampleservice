package org.omilab.services.exampleservice.service;

import org.omilab.services.exampleservice.model.LogMessage;
import org.omilab.services.exampleservice.model.Post;
import org.omilab.services.exampleservice.repo.InstanceRepository;
import org.omilab.services.exampleservice.repo.PageRepository;
import org.omilab.services.exampleservice.repo.PostRepository;
import org.omilab.services.exampleservice.repo.TopicRepository;
import org.omilab.services.exampleservice.service.logging.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by omilab on 14/01/17.
 */

@Component("PostMgmtService")
@Transactional
public class PostMgmtServiceImpl implements PostMgmtService{

    private final InstanceRepository instanceRepo;
    private final LoggingService logService;
    private final PostRepository postRepo;
    private final TopicRepository topicRepo;

    @Autowired
    public PostMgmtServiceImpl(final InstanceRepository instanceRepo, final LoggingService logService, final PostRepository postRepo, final TopicRepository topicRepo) {

        this.instanceRepo = instanceRepo;
        this.logService = logService;
        this.postRepo = postRepo;
        this.topicRepo = topicRepo;
    }

    @Override
    public void createPost( long topicId, String subject, String text, String username ) {
        postRepo.save( new Post( topicRepo.findTopicByTopicId(topicId), subject, text, username ) );
        //logService.logMessage(new LogMessage(user,"create","Post",id.toString()));
    }

    @Override
    public Set<Post> getPosts() {
        return postRepo.getPosts();
    }
}
