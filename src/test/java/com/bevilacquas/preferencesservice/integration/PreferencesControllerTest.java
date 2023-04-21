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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    assertEquals(1, repository.findAll().size());
  }

  @Test
  @DisplayName("Should receive HTTP 400 Bad Request when receive a request with empty preference name")
  void createPreferenceTest2() throws Exception {
    assertEquals(0, repository.findAll().size());
    mvc
      .perform(
        post(baseUrl)
          .contentType(APPLICATION_JSON)
          .content(objToJson(new PreferenceRequest(""))))
      .andExpect(status().isBadRequest());
    assertEquals(0, repository.findAll().size());
  }

  @Test
  @DisplayName("Should receive all preferences")
  void getPreferenceTest1() throws Exception {
    repository.saveAll(
        of(new Preference(randomUUID(), "preference1"), new Preference(randomUUID(), "preference2"))
    );
    assertEquals(2, repository.findAll().size());
    mvc
      .perform(get(baseUrl))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.[0].preference.id").exists())
      .andExpect(jsonPath("$.[0].preference.id").isString())
      .andExpect(jsonPath("$.[0].preference.id").isNotEmpty())
      .andExpect(jsonPath("$.[0].preference.name").value("preference1"))
      .andExpect(jsonPath("$.[1].preference.id").exists())
      .andExpect(jsonPath("$.[1].preference.id").isString())
      .andExpect(jsonPath("$.[1].preference.id").isNotEmpty())
      .andExpect(jsonPath("$.[1].preference.name").value("preference2"));
  }

  @Test
  @DisplayName("Should find preference by id")
  void getPreferenceTest2() throws Exception {
    var id = randomUUID();
    repository.save(new Preference(id, "preference1"));
    assertEquals(1, repository.findAll().size());
    mvc
      .perform(get(baseUrl + "/" + id))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.preference.id").exists())
      .andExpect(jsonPath("$.preference.id").isString())
      .andExpect(jsonPath("$.preference.id").isNotEmpty())
      .andExpect(jsonPath("$.preference.name").value("preference1"));
  }

  @Test
  @DisplayName("Should return HTTP 404 NOT FOUND when not finding the preference id")
  void getPreferenceTest3() throws Exception {
    repository.save(new Preference(randomUUID(), "preference1"));
    assertEquals(1, repository.findAll().size());
    mvc
      .perform(get(baseUrl + "/" + randomUUID()))
      .andExpect(status().isNotFound());
  }

  // TODO: 21-Apr-23 Define a business logic to update a preference: by id or by name.
  @Test
  @DisplayName("Should return HTTP 200 when updating existing preference")
  void updatePreferenceTest1() throws Exception {
    repository.save(new Preference(randomUUID(), "preference1"));
    assertEquals(1, repository.findAll().size());
    mvc
      .perform(
        put(baseUrl)
          .contentType(APPLICATION_JSON)
          .content(objToJson(new PreferenceRequest("preference new name"))))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.preference.id").exists())
      .andExpect(jsonPath("$.preference.id").isString())
      .andExpect(jsonPath("$.preference.id").isNotEmpty())
      .andExpect(jsonPath("$.preference.name").value("preference new name"));
    assertEquals(1, repository.findAll().size());
  }

  @Test
  @DisplayName("Should return HTTP 200 when deleting a preference")
  void deletePreferenceTest1() throws Exception {
    var p = new Preference(randomUUID(), "preference1");
    repository.save(p);
    assertEquals(1, repository.findAll().size());
    mvc
      .perform(
        delete(baseUrl)
          .contentType(APPLICATION_JSON)
          .content(objToJson(p)))
      .andExpect(status().isOk());
    assertEquals(0, repository.findAll().size());
  }
}
