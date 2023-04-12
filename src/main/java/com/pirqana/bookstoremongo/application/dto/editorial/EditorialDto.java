package com.pirqana.bookstoremongo.application.dto.editorial;

import lombok.Data;

@Data
public class EditorialDto {
    private String id;

    private String codigo;

    private String nombre;

    private String fechaRegistro;

    private Integer estado;
}
