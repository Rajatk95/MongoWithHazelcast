package com.architecture.prod.module;

import com.architecture.prod.cache.LookupMapstore;
import com.architecture.prod.dtos.LookupObject;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class LookupMapProvider implements Provider<IMap<String, LookupObject>> {

  private final HazelcastInstance hazelcastInstance;
  private final LookupMapstore mapstore;

  @Inject
  LookupMapProvider(final LookupMapstore mapstore) {
    this.hazelcastInstance = Hazelcast.newHazelcastInstance(createMapConfig());
    this.mapstore = mapstore;
  }

  @Override
  public IMap<String, LookupObject> get() {
    return hazelcastInstance.getMap("lookups");
  }

  public Config createMapConfig() {
    Config config = new Config();
    MapConfig mapConfig = new MapConfig("lookups");
    final MapStoreConfig storeConfig = new MapStoreConfig();
    storeConfig.setImplementation(mapstore).setEnabled(true).setWriteDelaySeconds(0);
    mapConfig.setMapStoreConfig(storeConfig);
    config.addMapConfig(mapConfig);
    return config;

  }
}
