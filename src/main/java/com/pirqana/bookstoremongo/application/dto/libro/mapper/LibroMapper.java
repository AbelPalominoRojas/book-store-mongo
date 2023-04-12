package com.pirqana.bookstoremongo.application.dto.libro.mapper;

import com.pirqana.bookstoremongo.application.dto.libro.LibroDto;
import com.pirqana.bookstoremongo.domain.entity.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LibroEditorialMapper.class})
public interface LibroMapper {

    @Mapping(source = "id",target = "id")
    @Mapping(source = "isbn" ,target = "isbn")
    @Mapping(source = "titulo" ,target = "titulo")
    @Mapping(source = "autores" ,target = "autores")
    @Mapping(source = "edicion" ,target = "edicion")
    @Mapping(source = "anio" ,target = "anio")
    @Mapping(source = "editorial" ,target = "editorial")
    @Mapping(source = "fechaRegistro",target = "fechaRegistro")
    @Mapping(source = "estado",target = "estado")
    LibroDto toLibroDto(Libro libro);
    List<LibroDto> toLibroDtos(List<Libro> libros);
}
