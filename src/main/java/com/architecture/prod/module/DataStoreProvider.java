package com.architecture.prod.module;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.architecture.prod.model.TenantContext;
import com.architecture.prod.model.TenantMap;
import com.google.inject.Inject;
import com.mongodb.MongoClient;

public class DataStoreProvider {

  private final List<TenantMap> tenantMap;

  @Inject
  DataStoreProvider(final List<TenantMap> tenantMap) {
    this.tenantMap = tenantMap;
  }

  public Datastore get() {
    final Morphia morphia = new Morphia();
    final String dbName = tenantMap.stream()
        .filter(tenantMap1 -> tenantMap1.getTenantId().equals(TenantContext.context))
        .findFirst()
        .orElse(new TenantMap("default")).getDbName();
   return morphia.createDatastore(new MongoClient(), dbName);
  }
}
