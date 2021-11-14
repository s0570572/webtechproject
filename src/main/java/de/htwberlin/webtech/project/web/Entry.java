package de.htwberlin.webtech.project.web;

import de.htwberlin.webtech.project.persistence.DifficultyEntity;
import de.htwberlin.webtech.project.persistence.TopicEntity;

public class Entry {
    private Long entryid;
    private String title;
    private String description;
    private TopicEntity topic;
    private DifficultyEntity difficulty;
    private String link;

    public Entry() {
    }

    public Entry(Long entryid, String title, String description, TopicEntity topic, DifficultyEntity difficulty, String link) {
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

    public Long getEntryid() {
        return entryid;
    }

    public void setEntryid(Long entryid) {
        this.entryid = entryid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public TopicEntity getTopic() {
        return topic;
    }

    public void setTopic(TopicEntity topic) {
        this.topic = topic;
    }

    public DifficultyEntity getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyEntity difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "title='" + title + '\'' +
                ", entryid=" + entryid +
                ", description='" + description + '\'' +
                ", topic=" + topic.toString() +
                ", difficulty=" + difficulty.toString() +
                ", link='" + link + '\'' +
                '}';
    }
}
