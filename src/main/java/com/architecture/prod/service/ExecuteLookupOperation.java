package com.architecture.prod.service;

import com.architecture.prod.dtos.LookupObject;
import com.architecture.prod.repository.LookupRepository;

public class ExecuteLookupOperation {
  public static void main(String arg[]){
    LookupRepository lookupRepository = new LookupRepository();
    LookupObject lookupObject = new LookupObject("lookupObject1", "lookupObject1", "lookupObject1", "lookupObject1",
        true, 1, true);
    lookupRepository.addLookupObject(lookupObject);

  }
}
