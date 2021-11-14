package de.htwberlin.webtech.project;

import de.htwberlin.webtech.project.persistence.DifficultyEntity;
import de.htwberlin.webtech.project.persistence.TopicEntity;
import de.htwberlin.webtech.project.web.Entry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntryTest {

    @Test
    void testToString(){

        String title = "Lake";
        String description = "fascinating pic of a forest lake";
        TopicEntity topic = TopicEntity.LANDSCAPE;
        DifficultyEntity difficulty = DifficultyEntity.ADVANCED;
        String link = "www.google.com";

        Entry entry = new Entry(57L, title, description, topic, difficulty, link);

        String expected = "Entry{entryid=57, title='Lake', description='fascinating pic of a forest lake', " +
                "topic='LANDSCAPE', difficulty='ADVANCED', link='www.google.com'}";

        String actual = entry.toString();

        assertEquals(expected, actual);
    }
}
