package com.pirqana.bookstoremongo.web.controller;

import com.pirqana.bookstoremongo.application.dto.libro.LibroDto;
import com.pirqana.bookstoremongo.application.service.LibroService;
import com.pirqana.bookstoremongo.web.config.DBCacheConfig;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libros")
@AllArgsConstructor
public class LibroController {

    private LibroService libroService;

    @GetMapping
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    @Cacheable(value = DBCacheConfig.CACHE_NAME)
    public ResponseEntity<List<LibroDto>> getAll() {
        return ResponseEntity.ok(libroService.findAll());
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<LibroDto> findById(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(libroService.findById(id).get());
    }
}
