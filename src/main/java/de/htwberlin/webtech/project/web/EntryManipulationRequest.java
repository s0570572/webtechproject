package de.htwberlin.webtech.project.web;

import de.htwberlin.webtech.project.persistence.DifficultyEntity;
import de.htwberlin.webtech.project.persistence.TopicEntity;

public class EntryManipulationRequest {

    private String title;
    private String description;
    private Topic topic;
    private Difficulty difficulty;
    private String link;

    public EntryManipulationRequest(String title, String description, Topic topic, Difficulty difficulty, String link) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.difficulty = difficulty;
        this.link = link;
    }

    public EntryManipulationRequest() {}

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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
