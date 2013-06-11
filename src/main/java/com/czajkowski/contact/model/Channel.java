package com.czajkowski.contact.model;

import javax.xml.bind.annotation.XmlElement;

public class Channel {
	
	String title;
	Astronomy astronomy;

	public String getTitle() {
		return title;
	}
 
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public Astronomy getAstronomy() {
		return astronomy;
	}

	@XmlElement(namespace="http://xml.weather.yahoo.com/ns/rss/1.0")
	public void setAstronomy(Astronomy astronomy) {
		this.astronomy = astronomy;
	}

}