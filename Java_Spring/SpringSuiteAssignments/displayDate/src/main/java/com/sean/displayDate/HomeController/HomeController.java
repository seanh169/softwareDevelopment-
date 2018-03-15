package com.sean.displayDate.HomeController;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "index";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		LocalDateTime thisDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, 'the' dd 'of' MMMM, yyyy");
		String formatDate = thisDate.format(formatter);
		model.addAttribute("date", formatDate);
		return "date";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		LocalDateTime thisDates = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
		String formatTime = thisDates.format(formatter);
		model.addAttribute("time", formatTime);
				
		return "time";
	}



}


