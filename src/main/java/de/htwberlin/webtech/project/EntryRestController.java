package de.htwberlin.webtech.project;

import de.htwberlin.webtech.project.backgroundlogic.Difficulty;
import de.htwberlin.webtech.project.backgroundlogic.Entry;
import de.htwberlin.webtech.project.backgroundlogic.Topic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EntryRestController {

    private List<Entry> entries;

    //to be modified
    public EntryRestController() {
        entries = new ArrayList<>();
        entries.add(new Entry(1L, "Autumn", "This is a picture of Berlin in autumn.", Topic.LANDSCAPE, Difficulty.MEDIUM, "www.google.com"));
        entries.add(new Entry(2L, "Young Lady", "", Topic.PEOPLE, Difficulty.ADVANCED, "www.wikipedia.org"));
    }

    @GetMapping(path = "/api/v1/entries")
    public ResponseEntity<List<Entry>> fetchEntries() {
        return ResponseEntity.ok(entries);
    }

}
