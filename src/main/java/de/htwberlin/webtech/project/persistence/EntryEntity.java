package de.htwberlin.webtech.project.persistence;

import de.htwberlin.webtech.project.web.Difficulty;
import de.htwberlin.webtech.project.web.Topic;

import javax.persistence.*;

@Entity(name = "entries")
public class EntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private Long entryid;
    @Column (name = "title", nullable = false)
    private String title;
    @Column (name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column (name = "topic", nullable = false)
    private Topic topic;
    @Enumerated(EnumType.STRING)
    @Column (name = "difficulty", nullable = false)
    private Difficulty difficulty;
    @Column (name = "link", nullable = false)
    private String link;

    public EntryEntity() {
    }

    public EntryEntity(String title, String description, Topic topic, Difficulty difficulty, String link) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.difficulty = difficulty;
        this.link = link;
    }

    public Long getEntryid() {
        return entryid;
    }

    public void setEntryid(Long entryid) {
        this.entryid = entryid;
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
