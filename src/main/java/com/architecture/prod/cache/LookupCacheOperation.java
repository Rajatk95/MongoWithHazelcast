package com.architecture.prod.cache;

import com.architecture.prod.dtos.LookupObject;
import com.google.inject.Inject;
import com.hazelcast.core.IMap;
import com.hazelcast.query.EntryObject;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.PredicateBuilder;

public class LookupCacheOperation {

  private final IMap<String, LookupObject> map ;

  /**
   * Gets the Object of Hazelcast map thru Guice bindings in LookupCacheModule.java
   * @param map
   */
  @Inject
  LookupCacheOperation(IMap<String, LookupObject> map) {
    this.map = map;
  }

  public LookupObject getLookupObjectById(String id) {
    return map.get(id);
  }

  public LookupObject addLookupObject(final LookupObject lookupObject) {
    map.put(lookupObject.getId(), lookupObject);
    return lookupObject;
  }

  public LookupObject updateLookupObject(LookupObject lookupObject) {
    map.put(lookupObject.getId(), lookupObject);
    return lookupObject;
  }

  public void deleteLookupObject(String id) {
    map.remove(id);
  }

  public LookupObject getActiveLookupByCode(String code) throws Exception{
    final EntryObject entryObject = new PredicateBuilder().getEntryObject();
    final Predicate predicate = entryObject.get("active").equal(true).and(entryObject.get("code").equal(code));
    return map.values(predicate).parallelStream()
        .findFirst()
        .orElseThrow(() -> new Exception("code not found" + "\n" + code));
  }
}
