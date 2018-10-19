package com.architecture.prod.repository;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.architecture.prod.dtos.LookupObject;
import com.mongodb.MongoClient;

public class LookupRepository {

  private static final String DEFAULT = "defaultLookup";
  private static final String ACTIVE = "active";

  private final Datastore datastore;

  public LookupRepository(){
    final Morphia morphia = new Morphia();
    this.datastore = morphia.createDatastore(new MongoClient(), "morphia_example");
  }

  public LookupObject getLookupObjectByTypeAndCode(final String code) {
    return datastore.createQuery(LookupObject.class).disableValidation().field("code").equal(code).get();
  }


  public void addLookupObject(final LookupObject lookupObject) {
    datastore.save(lookupObject);
  }

}