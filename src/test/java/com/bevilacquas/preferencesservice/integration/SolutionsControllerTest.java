package com.bevilacquas.preferencesservice.integration;

import com.bevilacquas.preferencesservice.application.preference.PreferenceRequest;
import com.bevilacquas.preferencesservice.application.solution.SolutionRequest;
import com.bevilacquas.preferencesservice.domain.entities.Preference;
import com.bevilacquas.preferencesservice.domain.entities.Solution;
import com.bevilacquas.preferencesservice.infrastructure.persistence.SolutionRepository;
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
public class SolutionsControllerTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private SolutionRepository repository;

  private final String baseUrl = "/api/v1/solutions";

  @BeforeEach
  void setup() {
    if(repository.findAll().size() > 0) repository.deleteAll();
  }

  @Test
  @DisplayName("Should create new solution")
  void createSolutionTest1() throws Exception {
    assertEquals(0, repository.findAll().size());
    mvc
      .perform(
        post(baseUrl)
          .contentType(APPLICATION_JSON)
          .content(objToJson(new SolutionRequest("solution1"))))
      .andExpect(status().isCreated())
      .andExpect(jsonPath("$.id").exists())
      .andExpect(jsonPath("$.id").isString())
      .andExpect(jsonPath("$.id").isNotEmpty())
      .andExpect(jsonPath("$.name").value("solution1"));
    assertEquals(1, repository.findAll().size());
  }

  @Test
  @DisplayName("Should receive HTTP 400 Bad Request when receive a request with empty solution name")
  void createSolutionTest2() throws Exception {
    assertEquals(0, repository.findAll().size());
    mvc
      .perform(
        post(baseUrl)
          .contentType(APPLICATION_JSON)
          .content(objToJson(new SolutionRequest(""))))
      .andExpect(status().isBadRequest());
    assertEquals(0, repository.findAll().size());
  }

  @Test
  @DisplayName("Should receive all solutions")
  void getSolutionTest1() throws Exception {
    repository.saveAll(
        of(new Solution(randomUUID(), "solution1"), new Solution(randomUUID(), "solution2"))
    );
    assertEquals(2, repository.findAll().size());
    mvc
      .perform(get(baseUrl))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.[0].solution.id").exists())
      .andExpect(jsonPath("$.[0].solution.id").isString())
      .andExpect(jsonPath("$.[0].solution.id").isNotEmpty())
      .andExpect(jsonPath("$.[0].solution.name").value("solution1"))
      .andExpect(jsonPath("$.[1].solution.id").exists())
      .andExpect(jsonPath("$.[1].solution.id").isString())
      .andExpect(jsonPath("$.[1].solution.id").isNotEmpty())
      .andExpect(jsonPath("$.[1].solution.name").value("solution2"));
  }

  @Test
  @DisplayName("Should find solution by id")
  void getSolutionTest2() throws Exception {
    var id = randomUUID();
    repository.save(new Solution(id, "preference1"));
    assertEquals(1, repository.findAll().size());
    mvc
      .perform(get(baseUrl + "/" + id))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.solution.id").exists())
      .andExpect(jsonPath("$.solution.id").isString())
      .andExpect(jsonPath("$.solution.id").isNotEmpty())
      .andExpect(jsonPath("$.solution.name").value("solution1"));
  }

  @Test
  @DisplayName("Should return HTTP 404 NOT FOUND when not finding the solution id")
  void getSolutionTest3() throws Exception {
    repository.save(new Solution(randomUUID(), "solution1"));
    assertEquals(1, repository.findAll().size());
    mvc
      .perform(get(baseUrl + "/" + randomUUID()))
      .andExpect(status().isNotFound());
  }

  // TODO: 21-Apr-23 Define a business logic to update a solution: by id or by name.
  @Test
  @DisplayName("Should return HTTP 200 when updating existing solution")
  void updateSolutionTest1() throws Exception {
    repository.save(new Solution(randomUUID(), "solution1"));
    assertEquals(1, repository.findAll().size());
    mvc
      .perform(
        put(baseUrl)
          .contentType(APPLICATION_JSON)
          .content(objToJson(new SolutionRequest("solution new name"))))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.solution.id").exists())
      .andExpect(jsonPath("$.solution.id").isString())
      .andExpect(jsonPath("$.solution.id").isNotEmpty())
      .andExpect(jsonPath("$.solution.name").value("solution new name"));
    assertEquals(1, repository.findAll().size());
  }

  @Test
  @DisplayName("Should return HTTP 200 when deleting a solution")
  void deleteSolutionTest1() throws Exception {
    var p = new Solution(randomUUID(), "solution1");
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
