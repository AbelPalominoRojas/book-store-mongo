package com.pirqana.bookstoremongo.application.dto.libro;

import lombok.Data;

@Data
public class LibroEditorialDto {
    private String codigo;

    private String nombre;

    private String fechaRegistro;

    private Integer estado;
}
