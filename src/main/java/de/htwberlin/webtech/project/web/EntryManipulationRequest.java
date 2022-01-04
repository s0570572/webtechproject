package de.htwberlin.webtech.project.web;

public class EntryManipulationRequest {

    private String title;
    private String description;
    private Topic topic;
    private Difficulty difficulty;
    private String link;
    private String kennwort;

    public EntryManipulationRequest(String title, String description, Topic topic, Difficulty difficulty, String link, String kennwort) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.difficulty = difficulty;
        this.link = link;
        this.kennwort = kennwort;
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

    public String getKennwort() {
        return kennwort;
    }

    public void setKennwort(String kennwort) {
        this.kennwort = kennwort;
    }
}
