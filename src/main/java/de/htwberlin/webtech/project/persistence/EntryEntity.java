package de.htwberlin.webtech.project.persistence;

import javax.persistence.*;

@Entity(name = "entry")
public class EntryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryid;
    @Column (name = "title")
    private String title;
    @Column (name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column (name = "topic")
    private Long topicId;
    @Enumerated(EnumType.STRING)
    @Column (name = "difficulty")
    private Long difficultyId;
    @Column (name = "link")
    private String link;

    public EntryEntity() {
    }

    public EntryEntity(String title, String description, Long topicId, Long difficultyId, String link) {
        this.title = title;
        this.description = description;
        this.topicId = topicId;
        this.difficultyId = difficultyId;
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

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(Long difficultyId) {
        this.difficultyId = difficultyId;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "title='" + title + '\'' +
                ", entryid=" + entryid +
                ", description='" + description + '\'' +
                ", topic=" + topicId +
                ", difficulty=" + difficultyId +
                ", link='" + link + '\'' +
                '}';
    }
}
