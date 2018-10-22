package com.architecture.prod.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.architecture.prod.model.UserRegionContext;

/**
 * Since the login, logout and session handling is not done in this project, To
 * test multi tenancy user needs to manualy set the context and then fire a
 * query.
 *
 */
@Path("/userContext")
public class UserContextSwitchingController {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getContext() {
		return UserRegionContext.getRegionId();
	}

	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	public void SetContext(final String context) {
		UserRegionContext.setRegionId(context);
	}
}
