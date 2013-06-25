package com.czajkowski.contact.controller;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.czajkowski.contact.form.Contact;
import com.czajkowski.contact.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());
		
		map.put("weather", contactService.getWeather());
		
		//Async test
		System.out.println("Async BEFORE time:" + new Date());
		Future<Integer> future = contactService.getMath(123);
		System.out.println("Async AFTER time:" + new Date());
		System.out.println("Async isDone 1: " + future.isDone());
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Async isDone 2: " + future.isDone());
		if (future.isDone()) {
			try {
				System.out.println("Async get: " + future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		return "contact";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") @Valid Contact contact, BindingResult result) {

		if (result.hasErrors()) {
			return "contact";
		}
		
		contactService.addContact(contact);
		
		return "redirect:/index";
	}

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		contactService.removeContact(contactId);

		return "redirect:/index";
	}
}
