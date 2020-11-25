package org.example.resources;

import org.example.dao.ContactDao;
import org.example.domain.Contact;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactsResource {

    private static final ContactDao dao = new ContactDao();

    @GET
    public List<Contact> getAll() {
        return dao.getAll();
    }

/*    @GET
    @Path("{id}")
    public Contact getbyId(@PathParam("id") int id){
        return dao.getById(id);
    }*/

}
