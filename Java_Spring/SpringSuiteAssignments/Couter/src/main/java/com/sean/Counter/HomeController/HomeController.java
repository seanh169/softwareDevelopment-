package com.sean.Counter.HomeController;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("counter") == null){
		session.setAttribute("counter", 0);
		}
		return "index";
	
	}
   
	@RequestMapping("/couter")
	public String couter(HttpSession session) {
		session.setAttribute("counter", (int) session.getAttribute("counter") +1);
		return "couter";
	}
}
