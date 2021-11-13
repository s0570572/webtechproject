package de.htwberlin.webtech.project.backgroundlogic;

import javax.persistence.*;

@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryid;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Topic topic;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    private String link;

    public Entry() {
    }

    public Entry(Long entryid, String title, String description, Topic topic, Difficulty difficulty, String link) {
        this.entryid = entryid;
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

    @Override
    public String toString() {
        return "Entry{" +
                "title='" + title + '\'' +
                ", entryid=" + entryid +
                ", description='" + description + '\'' +
                ", topic=" + topic +
                ", difficulty=" + difficulty +
                ", link='" + link + '\'' +
                '}';
    }
}
