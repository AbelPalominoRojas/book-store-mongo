package com.pirqana.bookstoremongo.infrastructure.repository;

import com.pirqana.bookstoremongo.domain.entity.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibroRepository extends MongoRepository<Libro, String> {
}
