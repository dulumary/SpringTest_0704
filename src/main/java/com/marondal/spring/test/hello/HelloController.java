package com.marondal.spring.test.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String helloworld() {
		return "Hello World";
	}

}