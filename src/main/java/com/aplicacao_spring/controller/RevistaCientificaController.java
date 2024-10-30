package com.aplicacao_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aplicacao_spring.dto.RevistaCientificaDTO;
import com.aplicacao_spring.model.RevistaCientifica;
import com.aplicacao_spring.service.RevistaCientificaService;

@RestController
@RequestMapping("/api/revistas")
public class RevistaCientificaController {
    @Autowired
    private RevistaCientificaService revistaCientificaService;

    // Listar todas as revistas científicas
    @GetMapping
    public ResponseEntity<List<RevistaCientificaDTO>> listarRevistas() {
        List<RevistaCientificaDTO> revistas = revistaCientificaService.listarTodas();
        return ResponseEntity.ok(revistas);
    }

    // Buscar revista por ID
    @GetMapping("/{id}")
    public ResponseEntity<RevistaCientificaDTO> buscarRevista(@PathVariable Long id) {
        RevistaCientificaDTO revista = revistaCientificaService.buscarRevistaPorId(id);
        return ResponseEntity.ok(revista);
    }

    // Criar uma nova revista
    @PostMapping
    public ResponseEntity<RevistaCientificaDTO> criarRevista(@RequestBody RevistaCientificaDTO revistaDTO) {
        RevistaCientificaDTO novaRevista = revistaCientificaService.criarRevista(revistaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaRevista);
    }

    // Atualizar uma revista existente
    @PutMapping("/{id}")
    public ResponseEntity<RevistaCientificaDTO> atualizarRevista(@PathVariable Long id, @RequestBody RevistaCientificaDTO revistaDTO) {
        RevistaCientificaDTO revistaAtualizada = revistaCientificaService.atualizarRevista(id, revistaDTO);
        return ResponseEntity.ok(revistaAtualizada);
    }

    // Deletar uma revista por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRevista(@PathVariable Long id) {
        revistaCientificaService.deletarRevista(id);
        return ResponseEntity.noContent().build();
    }
}
