package com.czajkowski.contact.dao;

import java.util.List;

import com.czajkowski.contact.form.Contact;


public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
