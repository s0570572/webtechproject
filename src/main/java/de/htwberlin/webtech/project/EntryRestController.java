package de.htwberlin.webtech.project;

import de.htwberlin.webtech.project.service.EntryService;
import de.htwberlin.webtech.project.web.Entry;
import de.htwberlin.webtech.project.web.EntryManipulationRequest;
import de.htwberlin.webtech.project.web.Topic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class EntryRestController {

    private final EntryService entryService;

    public EntryRestController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping(path = "/api/v1/entries")
    public ResponseEntity<List<Entry>> fetchEntries() {
        return ResponseEntity.ok(entryService.findAll());
    }

    @GetMapping(path = "/api/v1/entries/{entryid}")
    public ResponseEntity<Entry> fetchEntryById(@PathVariable Long entryid) {
        var entry = entryService.findById(entryid);
        return entry != null? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/api/v1/entries-by-{topic}")
    public ResponseEntity<Entry> fetchEntryByTopic(@PathVariable Topic topic) {
        var entry = entryService.findByTopic(topic);
        return entry != null? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/entries")
    public ResponseEntity<Void> createEntry(@RequestBody EntryManipulationRequest request) throws URISyntaxException {
        var entry = entryService.create(request);
        URI uri = new URI("/api/v1/entries/" + entry.getEntryid());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/entries/{entryid}")
    public ResponseEntity<Entry> updateEntry(@PathVariable Long entryid, @RequestBody EntryManipulationRequest request) {
        var entry = entryService.update(entryid, request);
        return entry != null? ResponseEntity.ok(entry) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/entries/{entryid}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long entryid) {
        boolean successful = entryService.deleteById(entryid);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
