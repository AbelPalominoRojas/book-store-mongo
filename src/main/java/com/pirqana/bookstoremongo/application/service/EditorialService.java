package com.pirqana.bookstoremongo.application.service;

import com.pirqana.bookstoremongo.application.dto.editorial.EditorialDto;
import com.pirqana.bookstoremongo.application.dto.editorial.EditorialSaveDto;

import java.util.List;
import java.util.Optional;

public interface EditorialService {
    List<EditorialDto> findAll();

    Optional<EditorialDto> findById(String id) throws Exception;

    EditorialDto create(EditorialSaveDto editorialSaveDto);

    EditorialDto edit(String id, EditorialSaveDto editorialSaveDto) throws Exception;

    EditorialDto disable(String id) throws Exception;
}
