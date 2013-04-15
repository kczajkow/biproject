package com.czajkowski.contact.service;

import java.util.List;

import com.czajkowski.contact.form.Contact;


public interface ContactService {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
