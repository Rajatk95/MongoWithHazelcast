package com.architecture.prod.module;


import com.architecture.prod.cache.LookupMapstore;
import com.google.inject.Inject;
import com.hazelcast.config.MapStoreConfig;
import javax.inject.Provider;

public class MapStoreConfigProvider implements Provider<MapStoreConfig> {

	private final LookupMapstore lookupMapstore;
	
	@Inject
	public MapStoreConfigProvider(final LookupMapstore lookupMapstore) {
		this.lookupMapstore = lookupMapstore;
	}
	
	@Override
	public MapStoreConfig get() {
		MapStoreConfig mapStoreConfig = new MapStoreConfig();
		mapStoreConfig.setImplementation(lookupMapstore).setEnabled(true).setWriteDelaySeconds(0);
		return mapStoreConfig;
	}

}
