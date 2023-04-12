package com.pirqana.bookstoremongo.application.dto.libro;

import lombok.Data;

import java.io.Serializable;

@Data
public class LibroEditorialDto implements Serializable {
    private String codigo;

    private String nombre;

    private String fechaRegistro;

    private Integer estado;
}
