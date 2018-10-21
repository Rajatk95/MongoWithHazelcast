package com.architecture.prod.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.architecture.prod.model.TenantContext;

@Path("/tenantContext")
public class TenantContextResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String test() {
    return TenantContext.getContext();
  }

  @PUT
  @Consumes(MediaType.TEXT_PLAIN)
  public void test(final String context) {
    TenantContext.setContext(context);
  }
}
