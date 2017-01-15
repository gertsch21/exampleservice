package org.omilab.services.exampleservice.repo;

import org.omilab.services.exampleservice.model.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by omilab on 14/01/17.
 */
public interface CommentRepository extends Repository<Comment, Long> {

    @Modifying
    @Transactional
    Comment save(Comment comment);

    @Query("select c from Comment c where c.post.postId = ?1")
    Set<Comment> findCommentsByPostId(long postId);


}
