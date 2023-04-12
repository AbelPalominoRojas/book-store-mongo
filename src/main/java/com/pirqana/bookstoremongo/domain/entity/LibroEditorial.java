package com.pirqana.bookstoremongo.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
public class LibroEditorial {
    private String codigo;

    private String nombre;

    @Field(name="fecha_registro")
    private String fechaRegistro;

    private Integer estado;
}
