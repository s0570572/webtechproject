package de.htwberlin.webtech.project;

import de.htwberlin.webtech.project.persistence.DifficultyEntity;
import de.htwberlin.webtech.project.persistence.EntryEntity;
import de.htwberlin.webtech.project.persistence.TopicEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EntryRestController {

    private List<EntryEntity> entries;

    //to be modified
    public EntryRestController() {
        entries = new ArrayList<>();
        entries.add(new EntryEntity(1L, "Autumn", "This is a picture of Berlin in autumn.", TopicEntity.LANDSCAPE, DifficultyEntity.MEDIUM, "www.google.com"));
        entries.add(new EntryEntity(2L, "Young Lady", "", TopicEntity.PEOPLE, DifficultyEntity.ADVANCED, "www.wikipedia.org"));
    }

    @GetMapping(path = "/api/v1/entries")
    public ResponseEntity<List<EntryEntity>> fetchEntries() {
        return ResponseEntity.ok(entries);
    }

    //GET

    //POST

    //DELETE
}
