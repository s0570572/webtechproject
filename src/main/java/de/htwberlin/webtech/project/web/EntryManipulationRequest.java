package de.htwberlin.webtech.project.web;

import de.htwberlin.webtech.project.persistence.DifficultyEntity;
import de.htwberlin.webtech.project.persistence.TopicEntity;

public class EntryManipulationRequest {

    private String title;
    private String description;
    private TopicEntity topic;
    private DifficultyEntity difficulty;
    private String link;

    public EntryManipulationRequest(String title, String description, TopicEntity topic, DifficultyEntity difficulty, String link) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.difficulty = difficulty;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TopicEntity getTopicEntity() {
        return topic;
    }

    public void setTopicEntity(TopicEntity topic) {
        this.topic = topic;
    }

    public DifficultyEntity getDifficultyEntity() {
        return difficulty;
    }

    public void setDifficultyEntity(DifficultyEntity difficulty) {
        this.difficulty = difficulty;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
