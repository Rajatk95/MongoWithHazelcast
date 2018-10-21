package com.architecture.prod.module;

import com.architecture.prod.cache.LookupMapstore;
import com.architecture.prod.model.LookupObject;
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
  private final String MAP_NAME = "LOOKUPS";

  @Inject
  LookupMapProvider(final LookupMapstore mapstore) {
    this.mapstore = mapstore;
    this.hazelcastInstance = Hazelcast.newHazelcastInstance(createMapConfig());
  }

  @Override
  public IMap<String, LookupObject> get() {
    return hazelcastInstance.getMap(MAP_NAME);
  }

  public Config createMapConfig() {
    Config config = new Config();
    MapConfig mapConfig = new MapConfig(MAP_NAME);
    final MapStoreConfig storeConfig = new MapStoreConfig();
    storeConfig.setImplementation(mapstore).setEnabled(true).setWriteDelaySeconds(0);
    mapConfig.setMapStoreConfig(storeConfig);
    config.addMapConfig(mapConfig);
    return config;

  }
}
