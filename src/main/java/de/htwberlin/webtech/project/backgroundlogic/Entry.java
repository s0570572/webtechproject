package de.htwberlin.webtech.project.backgroundlogic;

import java.util.List;

public class Entry {
String title;
Integer entryid;
String description;
List<String> topic;
List<String> difficulty;
String link;

    public Entry() {
    }

    public Entry(Integer entryid, String title, String link) {
        this.entryid = entryid;
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEntryid() {
        return entryid;
    }

    public void setEntryid(Integer entryid) {
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

    public List<String> getTopic() {
        return topic;
    }

    public void setTopic(List<String> topic) {
        this.topic = topic;
    }

    public List<String> getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(List<String> difficulty) {
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
