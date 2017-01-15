package org.omilab.services.exampleservice.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by omilab on 14/01/17.
 */

@Entity
public class Topic {

    @Id
    @GeneratedValue
    private long topicId;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy= "topic", cascade = {CascadeType.ALL})
    private Set<Post> posts;

    public Topic() {

    }

    public Topic(String name) {
        this.name = name;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
