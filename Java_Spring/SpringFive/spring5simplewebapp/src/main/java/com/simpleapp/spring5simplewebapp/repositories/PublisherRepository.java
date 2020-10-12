package com.simpleapp.spring5simplewebapp.repositories;

import com.simpleapp.spring5simplewebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
