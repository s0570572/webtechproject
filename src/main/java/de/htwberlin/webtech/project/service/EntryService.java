package de.htwberlin.webtech.project.service;

import de.htwberlin.webtech.project.persistence.EntryEntity;
import de.htwberlin.webtech.project.persistence.EntryRepository;
import de.htwberlin.webtech.project.web.Entry;
import de.htwberlin.webtech.project.web.EntryCreateRequest;
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

    public Entry create(EntryCreateRequest request) {
        var entryEntity = new EntryEntity(request.getTitle(), request.getDescription(), request.getTopicEntity(),
                request.getDifficultyEntity(), request.getLink());
        entryEntity = repo.save(entryEntity);
        return transformEntity(entryEntity);
    }

    private Entry transformEntity(EntryEntity entryEntity) {
        return new Entry(entryEntity.getEntryid(), entryEntity.getTitle(),
                entryEntity.getDescription(), entryEntity.getTopicEntity(), entryEntity.getDifficultyEntity(),
                entryEntity.getLink());
    }

    public EntryEntity get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Entry> findAll() {
        List<EntryEntity> entries = repo.findAll();
        return entries.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }
}
