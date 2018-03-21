package com.sean.relationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sean.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
