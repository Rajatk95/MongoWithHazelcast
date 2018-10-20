package com.architecture.prod.service;

import com.architecture.prod.dtos.LookupObject;
import com.architecture.prod.module.LookupModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class ExecuteLookupOperation {
  public static void main(String arg[]){
    Injector injector = Guice.createInjector(new LookupModule());
    LookupService lookupService = injector.getInstance(LookupService.class);

    LookupObject lookupObject = new LookupObject("lookupObject2", "lookupObject2", "lookupObject2", "lookupObject2",
        true, 1, true);
    lookupService.addLookupObject(lookupObject);

  }
}
