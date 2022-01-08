package de.htwberlin.webtech.project.service;

import de.htwberlin.webtech.project.persistence.EntryEntity;
import de.htwberlin.webtech.project.persistence.EntryRepository;
import de.htwberlin.webtech.project.service.EntryService;
import de.htwberlin.webtech.project.web.Difficulty;
import de.htwberlin.webtech.project.web.Topic;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class TransformEntityTest implements WithAssertions {

    @Mock
    private EntryRepository repo;

    @InjectMocks
    private EntryService underTest;

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
