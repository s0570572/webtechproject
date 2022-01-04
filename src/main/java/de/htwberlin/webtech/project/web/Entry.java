package de.htwberlin.webtech.project.web;

public class Entry {
    private Long entryid;
    private String title;
    private String description;
    private Topic topic;
    private Difficulty difficulty;
    private String link;
    private String kennwort;

    public Entry(Long entryid, String title, String description, Long topicId, Long difficultyId, String link, String kennwort) {
    }//entw. weiter mit Long id oder mit enum und hier String

    public Entry(Long entryid, String title, String description, Topic topic, Difficulty difficulty, String link, String kennwort) {
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

    public String getKennwort() {
        return kennwort;
    }

    public void setKennwort(String kennwort) {
        this.kennwort = kennwort;
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
