package com.architecture.prod.module;

import org.mongodb.morphia.Datastore;

import com.architecture.prod.repository.LookupRepository;
import com.architecture.prod.service.LookupService;
import com.architecture.prod.service.LookupServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.servlet.ServletModule;

/**
 * This class is called before the application is initializes. All the guice
 * bindings are initialized here and all the modules are installed.
 * 
 * @CalledFrom AppInitilizer.java
 * @category Module
 * @author RajatKhandelwal
 *
 */
public class LookupModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new ServletModule());
		install(new LookupCacheModule());
		bind(LookupService.class).to(LookupServiceImpl.class);
		bind(LookupRepository.class);
		bind(Datastore.class).toProvider(DataStoreProvider.class);
	}
}
