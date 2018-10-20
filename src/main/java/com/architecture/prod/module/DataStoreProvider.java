package com.architecture.prod.module;

import javax.inject.Provider;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;

public class DataStoreProvider implements Provider<Datastore> {

  @Override
  public Datastore get() {
    final Morphia morphia = new Morphia();
   return morphia.createDatastore(new MongoClient(), "morphia_example");
  }
}
