package com.pirqana.bookstoremongo.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "editoriales")
@Data
@NoArgsConstructor
public class Editorial {
    @Id
    @Field(name="_id",targetType = FieldType.OBJECT_ID)
    private String id;

    private String codigo;

    private String nombre;

    @Field(name="fecha_registro")
    private String fechaRegistro;

    private Integer estado;
}
