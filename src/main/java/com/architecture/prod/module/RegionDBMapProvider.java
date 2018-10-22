package com.architecture.prod.module;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import javax.inject.Provider;

import com.architecture.prod.model.RegionDBMap;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegionDBMapProvider implements Provider<List<RegionDBMap>> {

  private static final ObjectMapper MAPPER = new ObjectMapper();
  private static final String file_path = "/multi-tenancy-config.json";


  @Override
  public List<RegionDBMap> get() {
    try {
      return MAPPER.readValue(getClass().getResourceAsStream(file_path), new TypeReference<List<RegionDBMap>>(){});
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}
