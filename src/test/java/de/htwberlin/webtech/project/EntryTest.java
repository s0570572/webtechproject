//package de.htwberlin.webtech.project;

//import de.htwberlin.webtech.project.persistence.DifficultyEntity;
//import de.htwberlin.webtech.project.persistence.TopicEntity;
//import de.htwberlin.webtech.project.web.Entry;
//import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.assertEquals;

//class EntryTest {

//    @Test
//    void testToString(){

//        String title = "Lake";
//        String description = "fascinating pic of a forest lake";
//        Long topic = 3L;
//        Long difficulty = 3L;
//        String link = "www.google.com";

//        Entry entry = new Entry(3L, title, description, topic, difficulty, link);


//        String expected = "Entry{entryid=3, title='Lake', description='fascinating pic of a forest lake', " +
//                "topic=3, difficulty=3, link='www.google.com'}";

//        String actual = entry.toString();


//        assertEquals(expected, actual);
//    }
//}
