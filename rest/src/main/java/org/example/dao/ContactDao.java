package org.example.dao;

import org.example.domain.Contact;

import javax.ejb.Singleton;
import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@Singleton
public class ContactDao implements IContactDao {

    private int maxId = 0;

    private final Map<String, Contact> contacts;

    public ContactDao() {
        List<Contact> contacts = Arrays.asList(
                Contact.builder().id(nextId()).firstname("Sammie").surname("Smith").email("sam.smith@music.com").build(),
                Contact.builder().id(nextId()).firstname("Frank").surname("Muscles").email("frank@muscles.com").build(),
                Contact.builder().id(nextId()).firstname("Eddy").surname("Valentino").email("eddy@valfam.co.uk").build(),
                Contact.builder().id(nextId()).firstname("Bram").surname("Janssens").email("s.a.janssens@gmail.com").build()
        );

        this.contacts = contacts.stream().collect(toMap(Contact::getId, c -> c));
    }

    public Collection<Contact> getAll() {
        return contacts.values();
    }

    public Contact getById(String id) {
        return this.contacts.get(id);
    }

    public Collection<Contact> get(String q) {
        Predicate<Contact> p1 = c -> c.getFirstname() != null && c.getFirstname().contains(q);
        Predicate<Contact> p2 = c -> c.getSurname() != null && c.getSurname().contains(q);
        Predicate<Contact> p3 = c -> c.getEmail() != null && c.getEmail().contains(q);

        return getAll().stream()
                .filter(p1.or(p2).or(p3))
                .collect(toList());
    }

    public boolean add(Contact c) {
        if (c.getId() == null) c.setId(nextId());
        return this.contacts.put(c.getId(), c) == null;
    }

    public boolean remove(String id) {
        return this.contacts.remove(id) != null;
    }

    public boolean update(String id, Contact c) {
        return this.contacts.put(id, c) != null;
    }

    private String nextId() { return ++maxId + ""; }
}
