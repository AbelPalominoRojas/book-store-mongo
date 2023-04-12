package com.pirqana.bookstoremongo.application.dto.libro;

import lombok.Data;

import java.io.Serializable;

@Data
public class LibroDto implements Serializable {
    private String id;
    private String isbn;
    private String titulo;
    private String autores;
    private String edicion;
    private Integer anio;
    private LibroEditorialDto editorial;
    private String fechaRegistro;
    private Integer estado;
}
