package de.htwberlin.webtech.project.persistence;

import de.htwberlin.webtech.project.web.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository<EntryEntity, Long> {

    Optional<EntryEntity> findByTopic(Topic topic);

//    List<EntryEntity> findAllByDifficultyEntity(DifficultyEntity difficulty);

//    List<EntryEntity> findAllByTopicEntity(TopicEntity topic);

}
