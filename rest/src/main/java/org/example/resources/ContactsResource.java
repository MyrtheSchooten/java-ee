package org.example.resources;

import org.example.dao.ContactDao;
import org.example.dao.IContactDao;
import org.example.domain.Contact;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactsResource {

    @Inject
    private IContactDao dao;

    @GET
    public Collection<Contact> getAll(@QueryParam("q") String q) {
        return q == null ? dao.getAll() : dao.get(q);
    }

    @GET @Path("{id}")
    public Contact get(@PathParam("id") String id) {
        return dao.getById(id);
    }

    @POST
    public Contact post(Contact c) {
        if (dao.add(c)) {
            return c;
        } else {
            throw new RuntimeException("Post contact " + c + " failed.");
        }
    }

    @DELETE @Path("{id}")
    public void delete(@PathParam("id") String id) {
        if (!dao.remove(id)) {
            throw new BadRequestException("Delete contact with id " + id + " failed.");
        }
    }

    @PUT @Path("{id}")
    public Contact put(@PathParam("id") String id, Contact c) {
        if (dao.update(id, c)) {
            return c;
        } else {
            throw new RuntimeException("Update contact " + c + " failed.");
        }
    }
}
