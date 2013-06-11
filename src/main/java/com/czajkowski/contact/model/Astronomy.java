package com.czajkowski.contact.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Astronomy {
	
	String sunrise;
	String sunset;
	
	public String getSunrise() {
		return sunrise;
	}
	
	@XmlAttribute
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	
	public String getSunset() {
		return sunset;
	}
	
	@XmlAttribute
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

}