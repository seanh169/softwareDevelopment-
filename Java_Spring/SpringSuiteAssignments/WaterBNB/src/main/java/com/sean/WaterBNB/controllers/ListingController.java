package com.sean.WaterBNB.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sean.WaterBNB.models.Listing;
import com.sean.WaterBNB.models.Review;
import com.sean.WaterBNB.models.User;
import com.sean.WaterBNB.services.ListingService;
import com.sean.WaterBNB.services.ReviewService;
import com.sean.WaterBNB.services.UserService;

@Controller
@RequestMapping("/listings")
public class ListingController {
	private ListingService lS;
	private UserService uS;
	private ReviewService rS;
	
	public ListingController(ListingService lS, UserService uS, ReviewService rS) {
		this.lS = lS;
		this.uS = uS;
		this.rS = rS;
	}
	@RequestMapping("")
	public String listings(HttpSession session, Model model) {
		User user;
		if(session.getAttribute("id") != null) {
			user =  uS.find((long)session.getAttribute("id"));
			model.addAttribute("user", user);
		}
		
		model.addAttribute("listings", lS.all());
		
		return "guest";
		
	}
	@RequestMapping("/host")
	public String host(HttpSession session, Model model) {
		if(session.getAttribute("id") == null) {return "redirect:/users/new";}
		
		User user = uS.find( (long)session.getAttribute("id"));
		
		
		if(!user.isHost()) {
			return "redirect:/listings";
		}
		
		model.addAttribute("user", user);
		model.addAttribute("listing", new Listing());
		return "host";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("listing") Listing listing ,BindingResult res,HttpSession session) {
		if(session.getAttribute("id")==null) { return "redirect:/users/new";}
		User user = uS.find((long)session.getAttribute("id"));
		if(!user.isHost()) {
			return "redirect:/listings";
		}else {
			
		
		
		
			if(res.hasErrors()) {
				return "/listings/host";
			}else {
				listing.setUser(user);
				
				lS.create(listing);
				return "redirect:/listings/host";
			}
		
		}
	}
	@RequestMapping("{id}")
	public String find(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("id") != null) {
			User user = uS.find((long)session.getAttribute("id"));
			model.addAttribute("user", user);
		}
		
		model.addAttribute("listing", lS.find(id));
		
		return "reviews";
	}
	
	@RequestMapping("{id}/review")
	public String review(@PathVariable("id") Long id,HttpSession session, Model model) {
		if(session.getAttribute("id") != null) {
			User user = uS.find((long)session.getAttribute("id"));
			model.addAttribute("user", user);
		}else {
			return "redirect:/listings/"+id;
		}
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i=1;i<6;i++) 
			numbers.add(i);
		
		
		model.addAttribute("numbers",numbers);
		model.addAttribute("listing", lS.find(id));
		model.addAttribute("review", new Review());
		return "review";
	}
	
	@PostMapping("{id}/review")
	public String createReview(@PathVariable("id") Long id,@ModelAttribute("review") Review review, BindingResult res, HttpSession session) {
		if(session.getAttribute("id") == null) {
			return "/listings/"+id+"review";
		}
		User user = uS.find((long)session.getAttribute("id"));
		
		if (user.isHost()) {
			return "/listings/"+id+"/review";
		}
		
		if(res.hasErrors()) {
			return "review";
			}else {
				review.setUser(user);
				rS.create(review);
				return "redirect:/listings/"+id+"/review";
			}
		
	}
}
