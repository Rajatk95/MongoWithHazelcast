/*
 * This material is the confidential, unpublished property
 * of Fair Isaac Corporation.  Receipt or possession
 * of this material does not convey rights to divulge,
 * reproduce, use, or allow others to use it without
 * the specific written authorization of Fair Isaac
 * Corporation and use must conform strictly to the
 * license agreement.
 *
 * Copyright (c) Fair Isaac Corporation, 2016
 * All Rights Reserved.
 */

package com.architecture.prod.service;

import javax.inject.Singleton;

import com.architecture.prod.cache.LookupCacheOperation;
import com.google.inject.Inject;
import com.architecture.prod.model.LookupObject;

@Singleton
public class LookupServiceImpl implements LookupService {

  private static final String TYPE = "type";

  private final LookupCacheOperation lookupCacheOperation;

  @Inject
  LookupServiceImpl(final LookupCacheOperation lookupCacheOperation) {
    this.lookupCacheOperation = lookupCacheOperation;
  }

  /*@Override
  public LookupObject getLookupObjectByTypeAndCode(String code) {
    return lookupRepository.getLookupObjectByTypeAndCode(code);
  }*/

  @Override
  public LookupObject getLookupObjectById(String id) {
    return lookupCacheOperation.getLookupObjectById(id);
  }

  @Override
  public LookupObject addLookupObject(final LookupObject lookupObject) {
    lookupCacheOperation.addLookupObject(lookupObject);
    return lookupObject;
  }

  @Override
  public LookupObject updateLookupObject(LookupObject lookupObject) {
    lookupCacheOperation.updateLookupObject(lookupObject);
    return lookupObject;
  }

  @Override
  public void deleteLookupObject(String id) {
    lookupCacheOperation.deleteLookupObject(id);
  }

}
