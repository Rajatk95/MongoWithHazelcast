package com.architecture.prod.model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public final class LookupTenantMapName {

	private HashMap<String, String> lookupTenantMapName;
	private final List<TenantMap> listTenantMap;
	private final static String MAP_NAME_PREFIX = "LOOKUPS_";

	@Inject
	public LookupTenantMapName(final List<TenantMap> listTenantMap) {
		this.listTenantMap = listTenantMap;
		initializeHashMap();
	}

	private void initializeHashMap() {
		lookupTenantMapName = (HashMap<String, String>) this.listTenantMap.stream()
		.collect(Collectors.toMap(TenantMap::getTenantId, tenant ->  MAP_NAME_PREFIX + tenant.getTenantId()));
	}

	public final HashMap<String, String> getLookupTenantMapName() {
		return lookupTenantMapName;
	}
}
