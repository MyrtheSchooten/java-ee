package org.example.dao;

import org.example.domain.Contact;

import java.util.Collection;

public interface IContactDao {

    Collection<Contact> getAll();

    Contact getById(String id);

    Collection<Contact> get(String q);

    boolean add(Contact c);

    boolean remove(String id);

    boolean update(String id, Contact c);
}

