package com.aplicacao_spring.controller;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.aplicacao_spring.dto.ArtigoDTO;
import com.aplicacao_spring.model.Artigo;
import com.aplicacao_spring.service.ArtigoService;

@RestController
@RequestMapping("/api/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    // Listar todos os artigos
    @GetMapping
    public ResponseEntity<List<ArtigoDTO>> listarArtigos() {
        List<ArtigoDTO> artigos = artigoService.listarTodos();
        return ResponseEntity.ok(artigos);
    }

    // Buscar artigo por ID
    @GetMapping("/{id}")
    public ResponseEntity<ArtigoDTO> buscarArtigo(@PathVariable Long id) {
        ArtigoDTO artigo = artigoService.buscarArtigoPorId(id);
        return ResponseEntity.ok(artigo);
    }

    // Criar um novo artigo
    @PostMapping
    public ResponseEntity<ArtigoDTO> criarArtigo(@RequestBody ArtigoDTO artigoDTO) {
        ArtigoDTO novoArtigo = artigoService.criarArtigo(artigoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoArtigo);
    }

    // Atualizar um artigo existente
    @PutMapping("/{id}")
    public ResponseEntity<ArtigoDTO> atualizarArtigo(@PathVariable Long id, @RequestBody ArtigoDTO artigoDTO) {
        ArtigoDTO artigoAtualizado = artigoService.atualizarArtigo(id, artigoDTO);
        return ResponseEntity.ok(artigoAtualizado);
    }

    // Deletar um artigo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarArtigo(@PathVariable Long id) {
        artigoService.deletarArtigo(id);
        return ResponseEntity.noContent().build();
    }
}
