package com.architecture.prod.module;

import com.architecture.prod.cache.LookupMapstore;
import com.architecture.prod.model.LookupObject;
import com.architecture.prod.model.LookupTenantMapName;
import com.architecture.prod.model.TenantContext;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class LookupMapProvider {

	private final HazelcastInstance hazelcastInstance;
	private final MapStoreConfig storeConfig;
	private final LookupTenantMapName lookupTenantMapName;

	@Inject
	LookupMapProvider(final MapStoreConfig storeConfig, final LookupTenantMapName lookupTenantMapName) {
		this.storeConfig = storeConfig;
		this.lookupTenantMapName = lookupTenantMapName;
		this.hazelcastInstance = Hazelcast.newHazelcastInstance(createMapConfig());
	}

	public IMap<String, LookupObject> get() {
		return hazelcastInstance.getMap(lookupTenantMapName.getLookupTenantMapName().get(TenantContext.getContext()));
	}

	public Config createMapConfig() {
		Config config = new Config();
		MapConfig mapConfig = new MapConfig(lookupTenantMapName.getLookupTenantMapName().get(TenantContext.getContext()));
		mapConfig.setMapStoreConfig(storeConfig);
		config.addMapConfig(mapConfig);
		return config;
	}
}
