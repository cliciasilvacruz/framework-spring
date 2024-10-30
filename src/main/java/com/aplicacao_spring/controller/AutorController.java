package com.aplicacao_spring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aplicacao_spring.dto.AutorDTO;
import com.aplicacao_spring.model.Autor;
import com.aplicacao_spring.service.AutorService;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Listar todos os autores
    @GetMapping
    public ResponseEntity<List<AutorDTO>> listarAutores() {
        List<AutorDTO> autores = autorService.listarTodos();
        return ResponseEntity.ok(autores);
    }

    // Buscar autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> buscarAutor(@PathVariable Long id) {
        AutorDTO autor = autorService.buscarAutorPorId(id);
        return ResponseEntity.ok(autor);
    }

    // Criar um novo autor
    @PostMapping
    public ResponseEntity<AutorDTO> criarAutor(@RequestBody AutorDTO autorDTO) {
        AutorDTO novoAutor = autorService.criarAutor(autorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAutor);
    }

    // Atualizar um autor existente
    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> atualizarAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO) {
        AutorDTO autorAtualizado = autorService.atualizarAutor(id, autorDTO);
        return ResponseEntity.ok(autorAtualizado);
    }

    // Deletar um autor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Long id) {
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }
}
