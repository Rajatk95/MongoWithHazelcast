package com.architecture.prod.module;

import org.mongodb.morphia.Datastore;

import com.architecture.prod.repository.LookupRepository;
import com.architecture.prod.service.LookupService;
import com.architecture.prod.service.LookupServiceImpl;
import com.google.inject.AbstractModule;

public class LookupModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(LookupService.class).to(LookupServiceImpl.class);
    bind(LookupRepository.class);
    bind(Datastore.class).toProvider(DataStoreProvider.class);
  }
}
