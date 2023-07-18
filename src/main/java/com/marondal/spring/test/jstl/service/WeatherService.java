package com.marondal.spring.test.jstl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.jstl.domain.Weather;
import com.marondal.spring.test.jstl.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	// 모든 날씨 정보를 조회 한다. 
	public List<Weather> getWeatherHistory() {
		
		List<Weather> weatherHistory = weatherRepository.selectWeatherHistory();
		
		return weatherHistory;
		
	}

}
