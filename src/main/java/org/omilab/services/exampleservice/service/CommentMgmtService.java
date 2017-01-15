package org.omilab.services.exampleservice.service;

import org.omilab.services.exampleservice.model.Comment;
import org.omilab.services.exampleservice.model.Post;

import java.util.Set;

/**
 * Created by omilab on 14/01/17.
 */
public interface CommentMgmtService {

    public void createComment( long postId, String subject, String text);

    public Set<Comment> findCommentsByPostId( long postId );

}
