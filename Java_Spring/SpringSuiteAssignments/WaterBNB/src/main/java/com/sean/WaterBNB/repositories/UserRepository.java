package com.sean.WaterBNB.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sean.WaterBNB.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);

}
