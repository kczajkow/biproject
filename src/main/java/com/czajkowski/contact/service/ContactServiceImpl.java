package com.czajkowski.contact.service;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.czajkowski.contact.dao.ContactDAO;
import com.czajkowski.contact.dao.WeatherDAO;
import com.czajkowski.contact.form.Contact;
import com.czajkowski.contact.model.Weather;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;
	@Autowired
	private WeatherDAO weatherDAO;
	
	@Override
	@Transactional
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Override
	@Transactional
	public List<Contact> listContact() {
		return contactDAO.listContact();
	}
	
	@Override
	@Async
	public Future<Integer> getMath(int i) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new AsyncResult<Integer>(i);
	}
	
	@Override
	public Weather getWeather() {
		return weatherDAO.getWeather();
	}

	@Override
	@Transactional
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}
}
