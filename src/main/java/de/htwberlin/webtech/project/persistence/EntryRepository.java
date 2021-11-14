package de.htwberlin.webtech.project.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends CrudRepository<EntryEntity, Long> {
}
