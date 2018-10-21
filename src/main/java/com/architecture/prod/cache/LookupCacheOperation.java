package com.architecture.prod.cache;

import com.architecture.prod.model.LookupObject;
import com.architecture.prod.module.LookupMapProvider;
import com.google.inject.Inject;
import com.hazelcast.core.IMap;
import com.hazelcast.query.EntryObject;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.PredicateBuilder;

public class LookupCacheOperation {

  private final LookupMapProvider lookupMapProvider;

  /**
   * Gets the Object of Hazelcast map thru Guice bindings in LookupCacheModule.java
   * @param map
   */
  @Inject
  LookupCacheOperation(final LookupMapProvider lookupMapProvider) {
    this.lookupMapProvider = lookupMapProvider;
  }

  public LookupObject getLookupObjectById(String id) {
    return lookupMapProvider.get().get(id);
  }

  public LookupObject addLookupObject(final LookupObject lookupObject) {
	  lookupMapProvider.get().put(lookupObject.getId(), lookupObject);
    return lookupObject;
  }

  public LookupObject updateLookupObject(LookupObject lookupObject) {
	  lookupMapProvider.get().put(lookupObject.getId(), lookupObject);
    return lookupObject;
  }

  public void deleteLookupObject(String id) {
	  lookupMapProvider.get().remove(id);
  }

  public LookupObject getActiveLookupByCode(String code) throws Exception{
    final EntryObject entryObject = new PredicateBuilder().getEntryObject();
    final Predicate predicate = entryObject.get("active").equal(true).and(entryObject.get("code").equal(code));
    return lookupMapProvider.get().values(predicate).parallelStream()
        .findFirst()
        .orElseThrow(() -> new Exception("code not found" + "\n" + code));
  }
}
