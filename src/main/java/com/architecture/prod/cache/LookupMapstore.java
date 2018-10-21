package com.architecture.prod.cache;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import com.architecture.prod.model.LookupObject;
import com.architecture.prod.repository.LookupRepository;
import com.google.inject.Inject;
import com.hazelcast.core.MapStore;

public class LookupMapstore implements MapStore<String, LookupObject> {
  private final LookupRepository lookupRepository;

  @Inject
  LookupMapstore(final LookupRepository lookupRepository) {
    this.lookupRepository = lookupRepository;
  }
  @Override
  public void store(final String s, final LookupObject lookupObject) {
    lookupRepository.addLookupObject(lookupObject);
  }

  @Override
  public void storeAll(final Map<String, LookupObject> map) {
    map.forEach(this::store);
  }

  @Override
  public void delete(final String s) {
    lookupRepository.deleteLookupObject(s);
  }

  @Override
  public void deleteAll(final Collection<String> collection) {
    collection.forEach(this::delete);
  }

  @Override
  public LookupObject load(final String s) {
    return lookupRepository.get(s);
  }

  @Override
  public Map<String, LookupObject> loadAll(final Collection<String> collection) {
    return collection.stream().collect(Collectors.toMap(id-> id, this::load));
  }

  @Override
  public Iterable<String> loadAllKeys() {
    return lookupRepository.findIds();
  }
}
