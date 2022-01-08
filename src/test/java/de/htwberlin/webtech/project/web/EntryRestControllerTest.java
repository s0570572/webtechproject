package de.htwberlin.webtech.project.web;

import de.htwberlin.webtech.project.EntryRestController;
import de.htwberlin.webtech.project.service.EntryService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@WebMvcTest(EntryRestController.class)
public class EntryRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EntryService entryService;

    @Test
    @DisplayName("should return found entries from entry service")
    void should_return_found_entries_from_entry_service() throws Exception {
        // given
        var entries = List.of(
                new Entry(1L, "HTW in spring", "nice scenery of HTW in April", Topic.ARCHITECTURE, Difficulty.ADVANCED, "www.bing.com"),
                new Entry(2L, "Spreewald", "somewhere in Spreewald", Topic.LANDSCAPE, Difficulty.MEDIUM, "www.yahoo.com")
        );
        doReturn(entries).when(entryService).findAll();

        // when
        mockMvc.perform(get("/api/v1/entries"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].entryid").value(1))
                .andExpect(jsonPath("$[0].title").value("HTW in spring"))
                .andExpect(jsonPath("$[0].description").value("nice scenery of HTW in April"))
                .andExpect(jsonPath("$[0].topic").value("ARCHITECTURE"))
                .andExpect(jsonPath("$[0].difficulty").value("ADVANCED"))
                .andExpect(jsonPath("$[0].link").value("www.bing.com"))
                .andExpect(jsonPath("$[1].entryid").value(2))
                .andExpect(jsonPath("$[1].title").value("Spreewald"))
                .andExpect(jsonPath("$[1].description").value("somewhere in Spreewald"))
                .andExpect(jsonPath("$[1].topic").value("LANDSCAPE"))
                .andExpect(jsonPath("$[1].difficulty").value("MEDIUM"))
                .andExpect(jsonPath("$[1].link").value("www.yahoo.com"));
    }

    @Test
    @DisplayName("should return 404 if entry is not found")
    void should_return_404_if_entry_is_not_found() throws Exception {
        // given
        doReturn(null).when(entryService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/entries/152"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating an entry")
    void should_return_201_http_status_and_location_header_when_creating_an_entry() throws Exception {
        // given
        String entryToCreateAsJson = "{\"title\": \"HTW in spring\", \"description\":\"nice scenery of HTW in April\", \"topic\":\"ARCHITECTURE\", \"difficulty\": \"ADVANCED\", \"link\":\"www.bing.com\"}";
        var entry = new Entry(123L, null, null, null, null, null);
        doReturn(entry).when(entryService).create(any());

        // when
        mockMvc.perform(
                        post("/api/v1/entries")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(entryToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/entries/" + entry.getEntryid()))));
    }

    @Test
    @DisplayName("should validate create entry request")
    void should_validate_create_entry_request() throws Exception {
        // given
        String entryToCreateAsJson = "{\"title\": \"HTW in spring\", \"description\":\"nice scenery of HTW in April\", \"topic\":true, \"difficulty\": \"ADVANCED\", \"link\":\"www.bing.com\"}";

        // when
        mockMvc.perform(
                        post("/api/v1/entries")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(entryToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }

}
