package de.htwberlin.webtech.project.service;

import de.htwberlin.webtech.project.persistence.EntryEntity;
import de.htwberlin.webtech.project.persistence.EntryRepository;
import de.htwberlin.webtech.project.web.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryService {

    @Autowired
    private final EntryRepository repo;

    private Connection connection;

    public EntryService(EntryRepository repo) {
        this.repo = repo;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private Connection getConnection() {
        if (connection == null) {
            throw new RuntimeException("Connection not set");
        }
        return connection;
    }

    public EntryEntity save(EntryEntity entryEntity) {
        return repo.save(entryEntity);
    }

    public EntryEntity get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Entry> findAll() {
        List<EntryEntity> entries = repo.findAll();
        return entries.stream()
                .map(entryEntity -> new Entry(entryEntity.getEntryid(), entryEntity.getTitle(),
                        entryEntity.getDescription(), entryEntity.getTopic(), entryEntity.getDifficulty(),
                        entryEntity.getLink()))
                .collect(Collectors.toList());
    }
}
