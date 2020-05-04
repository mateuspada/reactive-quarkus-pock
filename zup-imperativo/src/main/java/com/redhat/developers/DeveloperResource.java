package com.redhat.developers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/developer")
public class DeveloperResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DeveloperDto> developers() {
        return Developer.<Developer>listAll().stream()
                .filter(developer -> developer.name.contains("a"))
                .map(DeveloperDto::of)
                .collect(Collectors.toList());
    }

}
