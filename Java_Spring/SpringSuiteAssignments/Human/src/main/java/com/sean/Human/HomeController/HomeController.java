package com.sean.Human.HomeController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String index(@RequestParam(value="name", required=false, defaultValue = "Human") String searchQuery) {
		return "Hello" + " " + searchQuery + "!" + "<br>" + "Welcome to Spring Boot";
	}
	
	
}
