package de.htwberlin.webtech.project.service;

import de.htwberlin.webtech.project.persistence.EntryEntity;
import de.htwberlin.webtech.project.persistence.EntryRepository;
import de.htwberlin.webtech.project.service.EntryService;
import de.htwberlin.webtech.project.web.Topic;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EntryServiceTest implements WithAssertions {

    @Mock
    private EntryRepository repo;

    @InjectMocks
    private EntryService underTest;

    @Test
    @DisplayName("should return true if delete was successful")
    void should_return_true_if_delete_was_successful() {
        // given
        Long givenId = 3L;
        doReturn(true).when(repo).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verify(repo).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if entry to delete does not exist")
    void should_return_false_if_person_to_delete_does_not_exist() {
        // given
        Long givenId = 3L;
        doReturn(false).when(repo).existsById(givenId);

        // when
        boolean result = underTest.deleteById(givenId);

        // then
        verifyNoMoreInteractions(repo);
        assertThat(result).isFalse();
    }

}
