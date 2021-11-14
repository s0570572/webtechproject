package de.htwberlin.webtech.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<EntryEntity, Long> {

//    List<EntryEntity> findAllByDifficultyEntity(DifficultyEntity difficulty);

//    List<EntryEntity> findAllByTopicEntity(TopicEntity topic);

}
