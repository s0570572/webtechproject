package de.htwberlin.webtech.project.persistence;

import javax.persistence.*;

@Entity(name = "entry")
public class EntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryid;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TopicEntity topicEntity;
    @Enumerated(EnumType.STRING)
    private DifficultyEntity difficultyEntity;
    private String link;

    public EntryEntity() {
    }

    public EntryEntity(Long entryid, String title, String description, TopicEntity topicEntity, DifficultyEntity difficultyEntity, String link) {
        this.entryid = entryid;
        this.title = title;
        this.description = description;
        this.topicEntity = topicEntity;
        this.difficultyEntity = difficultyEntity;
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
        return topicEntity;
    }

    public void setTopic(TopicEntity topicEntity) {
        this.topicEntity = topicEntity;
    }

    public DifficultyEntity getDifficulty() {
        return difficultyEntity;
    }

    public void setDifficulty(DifficultyEntity difficultyEntity) {
        this.difficultyEntity = difficultyEntity;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "title='" + title + '\'' +
                ", entryid=" + entryid +
                ", description='" + description + '\'' +
                ", topic=" + topicEntity +
                ", difficulty=" + difficultyEntity +
                ", link='" + link + '\'' +
                '}';
    }
}
