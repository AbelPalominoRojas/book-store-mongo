package com.pirqana.bookstoremongo.application.service;

import com.pirqana.bookstoremongo.application.dto.libro.LibroDto;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    List<LibroDto> findAll();

    Optional<LibroDto> findById(String id) throws Exception;
}
