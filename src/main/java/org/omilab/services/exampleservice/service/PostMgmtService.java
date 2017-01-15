package org.omilab.services.exampleservice.service;

import org.omilab.services.exampleservice.model.Comment;
import org.omilab.services.exampleservice.model.Post;
import org.omilab.services.exampleservice.model.Topic;

import java.util.Set;

/**
 * Created by omilab on 14/01/17.
 */
public interface PostMgmtService {

    public void createPost(long topicId, String subject, String text, String username);

    public Set<Post> getPosts( );

    public Post getPostBySubject(String subject);
}
