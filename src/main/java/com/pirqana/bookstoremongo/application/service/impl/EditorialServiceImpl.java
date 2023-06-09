package com.pirqana.bookstoremongo.application.service.impl;

import com.pirqana.bookstoremongo.application.dto.editorial.EditorialDto;
import com.pirqana.bookstoremongo.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookstoremongo.application.dto.editorial.mapper.EditorialMapper;
import com.pirqana.bookstoremongo.application.dto.editorial.mapper.EditorialSaveMapper;
import com.pirqana.bookstoremongo.application.service.EditorialService;
import com.pirqana.bookstoremongo.domain.entity.Editorial;
import com.pirqana.bookstoremongo.infrastructure.repository.EditorialRepository;
import com.pirqana.bookstoremongo.web.config.DBCacheConfig;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EditorialServiceImpl implements EditorialService {

    private EditorialRepository editorialRepository;

    private EditorialMapper editorialMapper;

    private EditorialSaveMapper editorialSaveMapper;

    @Override
    // @Cacheable(value = DBCacheConfig.CACHE_NAME)
    @Cacheable(value = "editoriales")
    public List<EditorialDto> findAll() {
        List<Editorial> editoriales = editorialRepository.findByEstadoOrderByIdDesc(1).get();
        return editorialMapper.toEditorialDtos(editoriales);
    }

    @Override
    @Cacheable(value = "editoriales", key = "#id")
    public Optional<EditorialDto> findById(String id) throws Exception {
        return Optional.ofNullable(editorialRepository.findById(id)
                .map(editorial -> editorialMapper.toEditorialDto(editorial))
                .orElseThrow(() -> new Exception("Editorial no se encontro para el id: " + id)));
    }

    @Override
    @CacheEvict(value = "editoriales", allEntries = true)
    public EditorialDto create(EditorialSaveDto editorialSaveDto) {
        Editorial editorial = editorialSaveMapper.toEditorial(editorialSaveDto);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        editorial.setFechaRegistro(LocalDateTime.now().format(formatter));
        editorial.setEstado(1);

        return editorialMapper.toEditorialDto(editorialRepository.save(editorial));
    }

    @Override
    @CacheEvict(value = "editoriales", allEntries = true)
    public EditorialDto edit(String id, EditorialSaveDto editorialSaveDto) throws Exception {
        Editorial editorialDb = editorialRepository.findById(id)
                .orElseThrow(() -> new Exception("Editorial no se encontro para el id: " + id));

        Editorial editorial = editorialSaveMapper.toEditorial(editorialSaveDto);
        editorial.setId(id);
        editorial.setFechaRegistro(editorialDb.getFechaRegistro());
        editorial.setEstado(editorialDb.getEstado());

        return editorialMapper.toEditorialDto(editorialRepository.save(editorial));
    }

    @Override
    // @CacheEvict(cacheNames = DBCacheConfig.CACHE_NAME, allEntries = true)
    @CacheEvict(value = "editoriales", allEntries = true)
    public EditorialDto disable(String id) throws Exception {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(() -> new Exception("Editorial no se encontro para el id: " + id));
        editorial.setEstado(0);

        return editorialMapper.toEditorialDto(editorialRepository.save(editorial));
    }
}
