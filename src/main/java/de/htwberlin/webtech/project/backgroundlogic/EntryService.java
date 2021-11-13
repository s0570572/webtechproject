package de.htwberlin.webtech.project.backgroundlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class EntryService {

    @Autowired
    EntryRepository repo;

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private Connection getConnection() {
        if (connection == null) {
            throw new RuntimeException("Connection not set");
        }
        return connection;
    }

    public Entry save(Entry entry) {
        return repo.save(entry);
    }

    public Entry get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
