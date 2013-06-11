package com.czajkowski.contact.service;

import java.util.List;

import com.czajkowski.contact.form.Contact;
import com.czajkowski.contact.model.Weather;


public interface ContactService {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public Weather getWeather();
	public void removeContact(Integer id);
}
