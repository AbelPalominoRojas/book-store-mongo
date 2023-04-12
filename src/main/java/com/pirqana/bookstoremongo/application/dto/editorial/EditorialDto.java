package com.pirqana.bookstoremongo.application.dto.editorial;

import lombok.Data;

import java.io.Serializable;

@Data
public class EditorialDto implements Serializable {
    private String id;

    private String codigo;

    private String nombre;

    private String fechaRegistro;

    private Integer estado;
}
