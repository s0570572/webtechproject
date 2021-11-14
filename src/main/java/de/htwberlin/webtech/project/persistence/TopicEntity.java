package de.htwberlin.webtech.project.persistence;

import de.htwberlin.webtech.project.web.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TopicEntity {
    @Id
    private Long topicid;
    private Topic topic;

    public TopicEntity(Long topicid, Topic topic) {
        this.topicid = topicid;
        this.topic = topic;
    }

    public TopicEntity() {

    }

    public Long getTopicid() {
        return topicid;
    }

//    public void setTopicid(Long topicid) {
//        this.topicid = topicid;
//    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
