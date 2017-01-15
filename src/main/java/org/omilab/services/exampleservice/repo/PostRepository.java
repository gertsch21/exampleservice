package org.omilab.services.exampleservice.repo;

import org.omilab.services.exampleservice.model.Comment;
import org.omilab.services.exampleservice.model.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by omilab on 14/01/17.
 */
public interface PostRepository extends Repository<Post, Long> {

    @Modifying
    @Transactional
    Post save(Post post);

    @Query("select p from Post p where p.postId = ?1")
    Post findPostByPostId(long postId);

    @Query("select p from Post AS p")
    Set<Post> getPosts();

}
