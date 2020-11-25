package org.example.dao;

import org.example.domain.Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactDao {

    private List<Contact> contacts = new ArrayList<>(Arrays.asList(
            Contact.builder().firstname("Een").surname("Een").email("een@een.com").build(),
            Contact.builder().firstname("Twee").surname("Twee").email("nogeenstwee@gmail.com").build(),
            Contact.builder().firstname("Drie").surname("Drie").email("driekeeris@scheepsrecht.nl").build(),
            Contact.builder().firstname("Vier").surname("Vier").email("vieristeveel@vier.org").build()
    ));

    public List<Contact> getAll() { return contacts; }


}

