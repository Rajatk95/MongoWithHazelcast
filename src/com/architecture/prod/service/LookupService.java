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

import java.util.List;

import com.architecture.prod.dtos.LookupObject;

public interface LookupService {

  LookupObject getLookupObjectById(String id);

  LookupObject addLookupObject(LookupObject lookupObject);

  LookupObject updateLookupObject(LookupObject lookupObject);

  void deleteLookupObject(String id);

}