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

import com.architecture.prod.model.LookupObject;

public interface LookupService {

  LookupObject getLookupObjectById(String id);

  LookupObject addLookupObject(LookupObject lookupObject);

  LookupObject updateLookupObject(LookupObject lookupObject);

  void deleteLookupObject(String id);

}