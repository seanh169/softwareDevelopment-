package com.sean.NinjaGold.HomeController;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Gold")
public class HomeController {
	private Random random;
	public HomeController() {
		this.random = new Random();
	}
	@PostMapping("/process")
	public String process(@RequestBody String body, HttpSession session) {
		
		body = body.substring(0,body.indexOf("="));
		int newGold = 0;
		String event = "You entered a ";
		switch(body) {
			case "cave":
				newGold += random.nextInt(6)+5;
				break;
			case "farm":
				newGold += random.nextInt(10)+11;
				break;
			case "house":
				newGold += random.nextInt(4)+2;
				break;
			case "casino":
				newGold += random.nextInt(100)+(-50);
				break;
		}
		String value="";
		if(newGold>0) {
			value=" earned ";
		}else {
			newGold = -newGold;
			value=" lost ";
		}
		SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		Date date = new Date();
		event += body + " and " + value + newGold+ " gold ("+format.format(date)+")";
		
		ArrayList<String> events = (ArrayList<String>) session.getAttribute("events");
		events.add(event);
		session.setAttribute("events", events);
		
		int oldGold = (int) session.getAttribute("gold");
		oldGold += newGold;
		session.setAttribute("gold", oldGold);
		
		session.setAttribute("newGold", newGold);
		
		System.out.println(event);
		
		return "redirect:/Gold";
	}
	@RequestMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("gold")==null) {
			session.setAttribute("events", new ArrayList<String>());
			session.setAttribute("gold", 0);
		}
		
		return "indexs";
	}
}
