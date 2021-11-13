package de.htwberlin.webtech.project.backgroundlogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class EntryService {

    @Autowired
    EntryRepository repo;

    public void setConnection(Connection connection) {

    }

    public void saveEntry(Entry entry) {

    }
}
