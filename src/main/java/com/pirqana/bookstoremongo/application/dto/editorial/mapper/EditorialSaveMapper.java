package com.pirqana.bookstoremongo.application.dto.editorial.mapper;

import com.pirqana.bookstoremongo.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookstoremongo.domain.entity.Editorial;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EditorialSaveMapper {

    @Mapping(source = "codigo",target = "codigo")
    @Mapping(source = "nombre",target = "nombre")
    EditorialSaveDto toEditorialSaveDto (Editorial editorial);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaRegistro", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Editorial toEditorial (EditorialSaveDto editorialSaveDto);
}
