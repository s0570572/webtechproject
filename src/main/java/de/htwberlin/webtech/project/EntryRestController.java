package de.htwberlin.webtech.project;

import de.htwberlin.webtech.project.service.EntryService;
import de.htwberlin.webtech.project.web.Entry;
import de.htwberlin.webtech.project.web.EntryCreateRequest;
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

    @PostMapping(path = "/api/v1/entries")
    public ResponseEntity<Void> createEntry(@RequestBody EntryCreateRequest request) throws URISyntaxException {
        var entry = entryService.create(request);
        URI uri = new URI("/api/v1/entries/" + entry.getEntryid());
        return ResponseEntity.created(uri).build();
    }

    //DELETE
}
