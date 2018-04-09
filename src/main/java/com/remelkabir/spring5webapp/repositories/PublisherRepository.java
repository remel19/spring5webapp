package com.remelkabir.spring5webapp.repositories;

import com.remelkabir.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
