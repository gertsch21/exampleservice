package org.omilab.services.exampleservice.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by omilab on 14/01/17.
 */

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long postId;

    @Column
    private String subject = "";

    @Column
    private String text = "";

    @Column
    private String author = "";

    @Column(nullable = false)
    private long date = System.currentTimeMillis();

    @OneToMany(fetch = FetchType.EAGER, mappedBy= "post", cascade = {CascadeType.ALL})
    private Set<Comment> comments;

    @ManyToOne
    private Topic topic;

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Post() {

    }

    public Post( Topic topic, String subject, String text, String username) {
        this.topic = topic;
        this.text = text;
        this.subject = subject;
        author = username;

    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", comments=" + comments +
                '}';
    }
}
