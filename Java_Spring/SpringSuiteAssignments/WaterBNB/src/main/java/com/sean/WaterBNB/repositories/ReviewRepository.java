package com.sean.WaterBNB.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sean.WaterBNB.models.Review;

@Repository

public interface ReviewRepository extends CrudRepository<Review, Long>{
	
	}
