package com.pirqana.bookstoremongo.application.dto.libro.mapper;

import com.pirqana.bookstoremongo.application.dto.editorial.EditorialDto;
import com.pirqana.bookstoremongo.application.dto.libro.LibroEditorialDto;
import com.pirqana.bookstoremongo.domain.entity.Editorial;
import com.pirqana.bookstoremongo.domain.entity.LibroEditorial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LibroEditorialMapper {

    @Mapping(source = "codigo",target = "codigo")
    @Mapping(source = "nombre",target = "nombre")
    @Mapping(source = "fechaRegistro",target = "fechaRegistro")
    @Mapping(source = "estado",target = "estado")
    LibroEditorialDto toEditorialDto(LibroEditorial editorial);
}
