package org.omilab.services.exampleservice.service;

import org.omilab.services.exampleservice.model.Comment;
import org.omilab.services.exampleservice.model.LogMessage;
import org.omilab.services.exampleservice.model.Post;
import org.omilab.services.exampleservice.repo.CommentRepository;
import org.omilab.services.exampleservice.repo.InstanceRepository;
import org.omilab.services.exampleservice.repo.PageRepository;
import org.omilab.services.exampleservice.repo.PostRepository;
import org.omilab.services.exampleservice.service.logging.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by omilab on 14/01/17.
 */

@Component("CommentMgmtService")
@Transactional
public class CommentMgmtServiceImpl implements CommentMgmtService{

    private final InstanceRepository instanceRepo;
    private final LoggingService logService;
    private final CommentRepository commRepo;
    private final PostRepository postRepo;

    @Autowired
    public CommentMgmtServiceImpl(final InstanceRepository instanceRepo, final LoggingService logService, final CommentRepository commRepo, final PostRepository postRepo) {

        this.instanceRepo = instanceRepo;
        this.logService = logService;
        this.commRepo = commRepo;
        this.postRepo = postRepo;
    }

    @Override
    public void createComment( final long postId, final String subject, final String text, final String author) {

        commRepo.save(new Comment(postRepo.findPostByPostId(postId), subject, text,author));
        //logService.logMessage(new LogMessage(user,"create","Post",id.toString()));
    }

    @Override
    public Set<Comment> findCommentsByPostId(long postId) {

        return commRepo.findCommentsByPostId(postId);

    }
}
