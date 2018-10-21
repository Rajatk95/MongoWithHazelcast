package com.architecture.prod.module;

import java.util.List;

import org.mongodb.morphia.Datastore;

import com.architecture.prod.TenantDBMapProvider;
import com.architecture.prod.model.TenantMap;
import com.architecture.prod.repository.LookupRepository;
import com.architecture.prod.service.LookupService;
import com.architecture.prod.service.LookupServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.servlet.ServletModule;

public class LookupModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ServletModule());
		install(new LookupCacheModule());
		bind(LookupService.class).to(LookupServiceImpl.class);
		bind(LookupRepository.class);
		bind(DataStoreProvider.class);
		bind( new TypeLiteral<List<TenantMap>>(){}).toProvider(TenantDBMapProvider.class);
	}
}
