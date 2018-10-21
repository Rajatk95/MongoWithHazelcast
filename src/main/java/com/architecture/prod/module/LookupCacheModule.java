package com.architecture.prod.module;

import com.architecture.prod.cache.LookupCacheOperation;
import com.architecture.prod.cache.LookupMapstore;
import com.architecture.prod.model.LookupObject;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.hazelcast.core.IMap;

public class LookupCacheModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(LookupCacheOperation.class);
    bind(LookupMapstore.class);
    bind(new TypeLiteral<IMap<String, LookupObject>>() {}).toProvider(LookupMapProvider.class);
  }
}
