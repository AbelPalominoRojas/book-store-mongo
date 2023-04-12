package com.pirqana.bookstoremongo.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "libros")
@Data
@NoArgsConstructor
public class Libro {
    @Id
    @Field(name="_id",targetType = FieldType.OBJECT_ID)
    private String id;

    private String isbn;
    private String titulo;
    private String autores;
    private String edicion;
    private Integer anio;
    private LibroEditorial editorial;

    @Field(name="fecha_registro")
    private String fechaRegistro;

    private Integer estado;
}
