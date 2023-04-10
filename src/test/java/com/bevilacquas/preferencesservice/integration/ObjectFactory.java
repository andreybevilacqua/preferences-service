package com.bevilacquas.preferencesservice.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectFactory {

  public static String objToJson(Object o) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(o);
  }
}
