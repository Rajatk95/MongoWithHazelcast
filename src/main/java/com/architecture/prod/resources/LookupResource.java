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

package com.architecture.prod.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.architecture.prod.model.LookupObject;
import com.architecture.prod.service.LookupService;

@Path("/system/lookups")
public class LookupResource {

    private final LookupService lookupService;
    
    /**
     * Use to test is Web Service is working.
     */
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
    	return "its working.....";
    }

    @Inject
    public LookupResource(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    @GET
    @Path("/{lookupId}")
    @Produces(APPLICATION_JSON)
    public LookupObject lookupObject(@PathParam("lookupId") String lookupId) {
        return this.lookupService.getLookupObjectById(lookupId);
    }

    @POST
    @Produces(APPLICATION_JSON)
    public void addLookup(LookupObject lookupObject) {
        lookupService.addLookupObject(lookupObject);
    }

    @PUT
    @Path("/{lookupId}")
    @Produces(APPLICATION_JSON)
    public LookupObject updateLookup(@PathParam("lookupId") String lookupId, LookupObject lookupObject) {
        return lookupService.updateLookupObject(lookupObject);
    }

    @DELETE
    @Path("/{lookupId}")
    @Produces(APPLICATION_JSON)
    public void deleteLookup(@PathParam("lookupId") String lookupId) {
        lookupService.deleteLookupObject(lookupId);
    }

}
