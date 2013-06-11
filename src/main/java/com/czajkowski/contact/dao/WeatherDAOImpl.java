package com.czajkowski.contact.dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.czajkowski.contact.model.Weather;

@Repository
public class WeatherDAOImpl implements WeatherDAO {

	@Override
	public Weather getWeather() {
		String weatherSearchUrl = "http://weather.yahooapis.com/forecastrss?w={cityID}&u=c";
		Source weatherSource = new RestTemplate().getForObject(weatherSearchUrl, Source.class, "511360");
		Weather weather = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Weather.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			weather = (Weather) jaxbUnmarshaller.unmarshal(weatherSource);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return weather;
	}

}
