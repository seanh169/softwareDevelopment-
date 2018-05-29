package com.sean.courses.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sean.courses.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);

}
