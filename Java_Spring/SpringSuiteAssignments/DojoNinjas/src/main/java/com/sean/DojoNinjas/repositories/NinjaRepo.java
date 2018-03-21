package com.sean.DojoNinjas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sean.DojoNinjas.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {

}
