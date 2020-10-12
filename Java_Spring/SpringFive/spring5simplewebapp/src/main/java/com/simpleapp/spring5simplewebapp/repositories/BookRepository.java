package com.simpleapp.spring5simplewebapp.repositories;

import com.simpleapp.spring5simplewebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
