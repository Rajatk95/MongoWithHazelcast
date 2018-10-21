package com.architecture.prod.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.mongodb.morphia.Datastore;

import com.architecture.prod.model.LookupObject;
import com.architecture.prod.module.DataStoreProvider;
import com.google.inject.Inject;

public class LookupRepository {

  private static final String DEFAULT = "defaultLookup";
  private static final String ACTIVE = "active";

  private final DataStoreProvider dataStoreProvider;

  @Inject
  public LookupRepository(final DataStoreProvider dataStoreProvider){
    this.dataStoreProvider = dataStoreProvider;
  }

  public LookupObject getLookupObjectCode(final String code) {
    return dataStoreProvider.get().createQuery(LookupObject.class).disableValidation().field("code").equal(code).get();
  }


  public void addLookupObject(final LookupObject lookupObject) {
    dataStoreProvider.get().save(lookupObject);
  }

  public void addOrUpdateLookupObject(final LookupObject lookupObject) {
    dataStoreProvider.get().save(lookupObject);
  }

  public void deleteLookupObject(String id) {
    dataStoreProvider.get().delete(dataStoreProvider.get().createQuery(LookupObject.class).field("id").equal(id));
  }

  public List<String> findIds() {
    return dataStoreProvider.get().find(LookupObject.class).asList().stream().map(LookupObject::getId).collect(Collectors.toList());
  }

  public LookupObject get(String id) {
    return dataStoreProvider.get().createQuery(LookupObject.class).field("id").equal(id).get();
  }
}