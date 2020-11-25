package org.example.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/helloworld")
public class HelloWorldResource {

    @GET
    public Response helloworldwithoptionalname(@QueryParam("n") String name) {
        String n = name != null ? name : "";
        return Response
                .ok()
                .entity("Hello world " + name + "!")
                .build();
    }

    @POST
    public Response post(String requestBody, @Context UriInfo uriInfo) {
        String body = requestBody != null ? requestBody:"";
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path("a_new_location");
        return Response
                .created(uriBuilder.build())
                .entity("Hello posted world!" + body)
                .build();
    }

    @GET
    @Path("/q")
    public Response helloworldqname(@QueryParam("n") String name) {
        return Response
                .ok()
                .entity("Hello " + name + "!")
                .build();
    }

    @GET
    @Path("{name}")
    public Response helloworldName(@PathParam("name") String name) {
        return Response
                .ok()
                .entity("Hello " + name + " vanuit de URL!")
                .build();
    }


}
