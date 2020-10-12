package com.simpleapp.spring5simplewebapp.repositories;

import com.simpleapp.spring5simplewebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
