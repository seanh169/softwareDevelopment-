package com.sean.WaterBNB.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.sean.WaterBNB.models.Listing;
import com.sean.WaterBNB.repositories.ListingRepository;

@Service
public class ListingService {
	private ListingRepository lR;
	
	public ListingService(ListingRepository lR) {
		this.lR= lR;
	}
	public void create(Listing listing) {
		lR.save(listing);
	}
	public Listing find(Long id) {
		return (Listing) lR.findById(id).orElse(null);
	}
	public ArrayList<Listing> all(){
		return (ArrayList<Listing>) lR.findAll();
	}
	public void destroy(Long id) {
		lR.delete(id);
	}
	public void update(Listing listing) {
		lR.save(listing);
	}
}
