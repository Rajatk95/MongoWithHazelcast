package com.architecture.prod.module;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import javax.inject.Provider;

import com.architecture.prod.model.TenantMap;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TenantMapProvider implements Provider<List<TenantMap>> {

  private static final ObjectMapper MAPPER = new ObjectMapper();
  private static  final String file_path = "/multi-tenant-config.json";


  @Override
  public List<TenantMap> get() {
    try {
      return MAPPER.readValue(getClass().getResourceAsStream(file_path), new TypeReference<List<TenantMap>>(){});
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}