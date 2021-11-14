package de.htwberlin.webtech.project.persistence;

import de.htwberlin.webtech.project.web.Difficulty;
import de.htwberlin.webtech.project.web.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DifficultyEntity {
    @Id
    private Long difficultyId;
    private Difficulty difficulty;

    public DifficultyEntity(Long difficultyId, Difficulty difficulty) {
        this.difficultyId = difficultyId;
        this.difficulty = difficulty;
    }

    public DifficultyEntity() {

    }

    public Long getDifficultyId() {
        return difficultyId;
    }

//    public void setDifficultyId(Long difficultyId) {
//        this.difficultyId = difficultyId;
//    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
