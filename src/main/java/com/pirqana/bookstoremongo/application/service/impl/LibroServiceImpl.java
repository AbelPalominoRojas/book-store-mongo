package com.pirqana.bookstoremongo.application.service.impl;

import com.pirqana.bookstoremongo.application.dto.libro.LibroDto;
import com.pirqana.bookstoremongo.application.dto.libro.mapper.LibroMapper;
import com.pirqana.bookstoremongo.application.service.LibroService;
import com.pirqana.bookstoremongo.domain.entity.Libro;
import com.pirqana.bookstoremongo.infrastructure.repository.LibroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LibroServiceImpl implements LibroService {

    private LibroRepository libroRepository;
    private LibroMapper libroMapper;

    @Override
    public List<LibroDto> findAll() {
        List<Libro> libros = libroRepository.findAll();
        return libroMapper.toLibroDtos(libros);
    }

    @Override
    public Optional<LibroDto> findById(String id) throws Exception {
        var libro = libroRepository.findById(id).map(l -> libroMapper.toLibroDto(l));
        return Optional.of(libro)
                .orElseThrow(() -> new Exception("Libro no se encontro para el id: " + id));
    }
}
