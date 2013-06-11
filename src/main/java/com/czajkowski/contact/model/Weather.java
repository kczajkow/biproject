package com.czajkowski.contact.model;

import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="rss")
public class Weather {
 
	Channel channel;
 
	public Channel getChannel() {
		return channel;
	}
 
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}