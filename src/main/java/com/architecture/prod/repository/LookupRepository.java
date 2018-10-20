package com.architecture.prod.repository;

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
    /*final Morphia morphia = new Morphia();
    this.datastore = morphia.createDatastore(new MongoClient(), "morphia_example");*/
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

  public LookupObject get(String id) {
    return datastore.createQuery(LookupObject.class).field("id").equal(id).get();
  }
}