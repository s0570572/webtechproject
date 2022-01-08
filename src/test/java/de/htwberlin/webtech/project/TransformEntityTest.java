package de.htwberlin.webtech.project;

import de.htwberlin.webtech.project.persistence.EntryEntity;
import de.htwberlin.webtech.project.persistence.EntryRepository;
import de.htwberlin.webtech.project.service.EntryService;
import de.htwberlin.webtech.project.web.Difficulty;
import de.htwberlin.webtech.project.web.Topic;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

public class TransformEntityTest implements WithAssertions {

    private EntryRepository repo = new EntryRepository() {
        @Override
        public Optional<EntryEntity> findByTopic(Topic topic) {
            return Optional.empty();
        }

        @Override
        public List<EntryEntity> findAll() {
            return null;
        }

        @Override
        public List<EntryEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<EntryEntity> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends EntryEntity> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends EntryEntity> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends EntryEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<EntryEntity> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public EntryEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public EntryEntity getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends EntryEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends EntryEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<EntryEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends EntryEntity> S save(S entity) {
            return null;
        }

        @Override
        public Optional<EntryEntity> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(EntryEntity entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends EntryEntity> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends EntryEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends EntryEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends EntryEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends EntryEntity> boolean exists(Example<S> example) {
            return false;
        }
    };
    private final EntryService underTest = new EntryService(this.repo = repo);

    @Test
    @DisplayName("should transform EntryEntity to Entry")
    void should_transform_person_entity_to_person() {
        // given
        var entryEntity = Mockito.mock(EntryEntity.class);
        doReturn(111L).when(entryEntity).getEntryid();
        doReturn("Red flowers").when(entryEntity).getTitle();
        doReturn("A nice still-life").when(entryEntity).getDescription();
        doReturn(Topic.STILLLIFE).when(entryEntity).getTopic();
        doReturn(Difficulty.MEDIUM).when(entryEntity).getDifficulty();
        doReturn("www.google.com").when(entryEntity).getLink();

        // when
        var result = underTest.transformEntity(entryEntity);

        // then
        assertThat(result.getEntryid()).isEqualTo(111);
        assertThat(result.getTitle()).isEqualTo("Red flowers");
        assertThat(result.getDescription()).isEqualTo("A nice still-life");
        assertThat(result.getTopic()).isEqualTo(Topic.STILLLIFE);
        assertThat(result.getDifficulty()).isEqualTo(Difficulty.MEDIUM);
        assertThat(result.getLink()).isEqualTo("www.google.com");
    }
}
