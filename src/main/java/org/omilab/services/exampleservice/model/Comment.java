package org.omilab.services.exampleservice.model;

import javax.persistence.*;

/**
 * Created by omilab on 14/01/17.
 */

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private long commentId;

    @Column
    private String subject = "";

    @Column
    private String text = "";

    @Column
    private String author = "";

    @Column(nullable = false)
    private long date = System.currentTimeMillis();

    @ManyToOne
    private Post post;

    public Comment() {

    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", post=" + post.getPostId() +
                '}';
    }

    public Comment(Post post, String subject, String text, String author) {
        this.text = text;
        this.subject = subject;
        this.post = post;
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        commentId = commentId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
