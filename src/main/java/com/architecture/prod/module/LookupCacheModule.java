package com.architecture.prod.module;

import javax.inject.Provider;

import com.architecture.prod.cache.LookupCacheOperation;
import com.architecture.prod.cache.LookupMapstore;
import com.architecture.prod.model.LookupObject;
import com.architecture.prod.model.LookupTenantMapName;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.IMap;

/**
 * Guice Bindings related to Hazelcast IMap are here.
 * @CalledFrom LookupModule.java
 * @author RajatKhandelwal
 *
 */
public class LookupCacheModule extends AbstractModule {

  @Override
  protected void configure() {
	bind(LookupTenantMapName.class).asEagerSingleton();
	bind(LookupMapProvider.class);
    bind(LookupCacheOperation.class);
    bind(LookupMapstore.class);
    bind(MapStoreConfig.class).toProvider(MapStoreConfigProvider.class);
    
  }
}
