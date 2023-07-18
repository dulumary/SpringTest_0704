package com.marondal.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marondal.spring.test.jstl.domain.Weather;
import com.marondal.spring.test.jstl.service.WeatherService;

@RequestMapping("/jstl/weather")
@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/list")
	public String weatherList(Model model) {
		
		List<Weather> weatherHistory = weatherService.getWeatherHistory();
		
		model.addAttribute("weatherHistory", weatherHistory);
		
		return "jstl/weather/list";
		
	}
	
	@GetMapping("/input")
	public String weatherInput() {
		
		return "jstl/weather/input";
		
	}

}
