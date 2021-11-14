package de.htwberlin.webtech.project;

import de.htwberlin.webtech.project.service.EntryService;
import de.htwberlin.webtech.project.web.Entry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //GET

    //POST

    //DELETE
}
