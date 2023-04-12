package com.pirqana.bookstoremongo.web.controller;

import com.pirqana.bookstoremongo.application.dto.editorial.EditorialDto;
import com.pirqana.bookstoremongo.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookstoremongo.application.service.EditorialService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoriales")
@AllArgsConstructor
public class EditorialController {

    private EditorialService editorialService;

    @GetMapping
    public ResponseEntity<List<EditorialDto>> getAll() {
        return ResponseEntity.ok(editorialService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorialDto> findById(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(editorialService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<EditorialDto> create(@RequestBody EditorialSaveDto editorialSaveDto) {
        return ResponseEntity.ok(editorialService.create(editorialSaveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditorialDto> edit(@PathVariable("id") String id, @RequestBody EditorialSaveDto editorialSaveDto) throws Exception {
        return ResponseEntity.ok(editorialService.edit(id, editorialSaveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EditorialDto> disable(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(editorialService.disable(id));
    }
}
