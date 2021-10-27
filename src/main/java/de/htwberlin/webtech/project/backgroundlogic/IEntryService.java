package de.htwberlin.webtech.project.backgroundlogic;

import java.sql.Connection;

public interface IEntryService {
    void setConnection (Connection connection);
    void saveEntry (Entry entry);
}
