package com.architecture.prod.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.mongodb.morphia.Datastore;

import com.architecture.prod.dtos.LookupObject;
import com.google.inject.Inject;

public class LookupRepository {

  private static final String DEFAULT = "defaultLookup";
  private static final String ACTIVE = "active";

  private final Datastore datastore;

  @Inject
  public LookupRepository(final Datastore ds){
    this.datastore = ds;
  }

  public LookupObject getLookupObjectCode(final String code) {
    return datastore.createQuery(LookupObject.class).disableValidation().field("code").equal(code).get();
  }


  public void addLookupObject(final LookupObject lookupObject) {
    datastore.save(lookupObject);
  }

  public void addOrUpdateLookupObject(final LookupObject lookupObject) {
    datastore.save(lookupObject);
  }

  public void deleteLookupObject(String id) {
    datastore.delete(datastore.createQuery(LookupObject.class).field("id").equal(id));
  }

  public List<String> findIds() {
    return datastore.find(LookupObject.class).asList().stream().map(LookupObject::getId).collect(Collectors.toList());
  }

  public LookupObject get(String id) {
    return datastore.createQuery(LookupObject.class).field("id").equal(id).get();
  }
}