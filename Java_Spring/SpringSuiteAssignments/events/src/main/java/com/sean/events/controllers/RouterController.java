package com.sean.events.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/**")
public class RouterController {
	
	
	@RequestMapping("")
	public String index() {
		return "index";
	}

}
