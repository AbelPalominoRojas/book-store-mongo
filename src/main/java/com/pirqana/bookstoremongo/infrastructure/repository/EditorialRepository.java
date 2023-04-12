package com.pirqana.bookstoremongo.infrastructure.repository;

import com.pirqana.bookstoremongo.domain.entity.Editorial;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EditorialRepository extends MongoRepository<Editorial, String> {
    Optional<List<Editorial>> findByEstadoOrderByIdDesc(Integer estado);
}
