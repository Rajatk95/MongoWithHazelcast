package com.architecture.prod.module;

import com.architecture.prod.model.Customer;
import com.architecture.prod.model.CustomerRegionMapName;
import com.architecture.prod.model.UserRegionContext;
import com.google.inject.Inject;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class CustomerMapProvider {

	private final HazelcastInstance hazelcastInstance;
	private final MapStoreConfig storeConfig;
	private final CustomerRegionMapName customerRegionMapName;

	@Inject
	CustomerMapProvider(final MapStoreConfig storeConfig, final CustomerRegionMapName customerRegionMapName) {
		this.storeConfig = storeConfig;
		this.customerRegionMapName = customerRegionMapName;
		this.hazelcastInstance = Hazelcast.newHazelcastInstance(createMapConfig());
	}

	public IMap<String, Customer> get() {
		return hazelcastInstance.getMap(customerRegionMapName.getRegionCutomerMapName().get(UserRegionContext.getRegionId()));
	}

	public Config createMapConfig() {
		Config config = new Config();
		MapConfig mapConfig = new MapConfig(customerRegionMapName.getRegionCutomerMapName().get(UserRegionContext.getRegionId()));
		mapConfig.setMapStoreConfig(storeConfig);
		config.addMapConfig(mapConfig);
		return config;
	}
}
