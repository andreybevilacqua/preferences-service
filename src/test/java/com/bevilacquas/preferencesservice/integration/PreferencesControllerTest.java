package com.bevilacquas.preferencesservice.integration;

import com.bevilacquas.preferencesservice.application.preference.PreferenceRequest;
import com.bevilacquas.preferencesservice.domain.entities.Preference;
import com.bevilacquas.preferencesservice.infrastructure.persistence.PreferencesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static com.bevilacquas.preferencesservice.integration.ObjectFactory.objToJson;
import static java.util.List.of;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(value = {"classpath:/application.properties"})
@AutoConfigureMockMvc
public class PreferencesControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private PreferencesRepository repository;

  private final String baseUrl = "/api/v1/preferences";

  @BeforeEach
  void setup() {
    if(repository.findAll().size() > 0) repository.deleteAll();
  }

  @Test
  @DisplayName("Should create new preference")
  void createPreferenceTest1() throws Exception {
    assertEquals(0, repository.findAll().size());
    mvc
      .perform(
        post(baseUrl)
          .contentType(APPLICATION_JSON)
          .content(objToJson(new PreferenceRequest("preference1"))))
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id").exists())
      .andExpect(jsonPath("$.id").isString())
      .andExpect(jsonPath("$.id").isNotEmpty())
      .andExpect(jsonPath("$.name").value("preference1"));
  }

  // TODO: 10-Apr-23 Add business validation to check if the preference name is not empty.
  @Test
  @DisplayName("Should receive HTTP 400 Bad Request when receive a request with empty preference name")
  void createPreferenceTest2() throws Exception {
    assertEquals(0, repository.findAll().size());
    mvc
      .perform(
        post(baseUrl)
          .contentType(APPLICATION_JSON)
          .content(objToJson(new PreferenceRequest(""))))
      .andExpect(status().isBadRequest())
      .andDo(print());
  }

  @Test
  @DisplayName("Should receive all preferences")
  void getPreferenceTest1() throws Exception {
    var uuid1 = randomUUID();
    var uuid2 = randomUUID();
    repository.saveAll(
        of(new Preference(uuid1, "preference1"), new Preference(uuid2, "preference2"))
    );
    assertEquals(2, repository.findAll().size());
    mvc
      .perform(get(baseUrl))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.[0].id").exists())
      .andExpect(jsonPath("$.[0].id").isString())
      .andExpect(jsonPath("$.[0].id").isNotEmpty())
      .andExpect(jsonPath("$.[0].name").value("preference1"))
      .andExpect(jsonPath("$.[0].name").value("preference1"))
      .andExpect(jsonPath("$.[1].id").exists())
      .andExpect(jsonPath("$.[1].id").isString())
      .andExpect(jsonPath("$.[1].id").isNotEmpty())
      .andExpect(jsonPath("$.[1].name").value("preference2"))
      .andDo(print());
  }
}
