package com.sean.WaterBNB.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


import com.sean.WaterBNB.models.Review;
import com.sean.WaterBNB.repositories.ReviewRepository;

@Service
public class ReviewService {
	private ReviewRepository rR;
	
	public ReviewService(ReviewRepository rR) {
		
	}

public void create(Review review) {
	rR.save(review);
}
public Review find(Long id) {
	return (Review) rR.findById(id).orElse(null);
}
public ArrayList<Review> all(){
	return (ArrayList<Review>) rR.findAll();
}
public void destroy(Long id) {
	rR.deleteById(id);
}
public void update(Review review) {
	rR.save(review);
}

}
