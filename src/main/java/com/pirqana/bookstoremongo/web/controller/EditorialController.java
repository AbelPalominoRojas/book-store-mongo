package com.pirqana.bookstoremongo.web.controller;

import com.pirqana.bookstoremongo.application.dto.editorial.EditorialDto;
import com.pirqana.bookstoremongo.application.dto.editorial.EditorialSaveDto;
import com.pirqana.bookstoremongo.application.service.EditorialService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<List<EditorialDto>> getAll() {
        return ResponseEntity.ok(editorialService.findAll());
    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<EditorialDto> findById(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(editorialService.findById(id).get());
    }

    @PostMapping
    @ApiResponse(responseCode = "200")
    public ResponseEntity<EditorialDto> create(@RequestBody EditorialSaveDto editorialSaveDto) {
        return ResponseEntity.ok(editorialService.create(editorialSaveDto));
    }

    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<EditorialDto> edit(@PathVariable("id") String id, @RequestBody EditorialSaveDto editorialSaveDto) throws Exception {
        return ResponseEntity.ok(editorialService.edit(id, editorialSaveDto));
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "200")
    @ApiResponse(responseCode = "400", description = "Invalid id", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
    public ResponseEntity<EditorialDto> disable(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(editorialService.disable(id));
    }
}
