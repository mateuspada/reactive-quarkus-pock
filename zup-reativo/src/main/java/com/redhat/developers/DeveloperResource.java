package com.redhat.developers;

import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.sqlclient.Pool;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/developer")
public class DeveloperResource {

    @Inject
    Pool client;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<DeveloperDto> developers() {
        return Developer.listAll(client)
                .transform().byFilteringItemsWith(developer -> developer.getName().contains("a"))
                .map(DeveloperDto::of);
    }

}
