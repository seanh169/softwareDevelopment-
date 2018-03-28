package com.sean.WaterBNB.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sean.WaterBNB.models.Listing;

public interface ListingRepository extends CrudRepository<Listing, Long> {

}
