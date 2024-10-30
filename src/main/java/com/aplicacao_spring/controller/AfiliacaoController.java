package com.aplicacao_spring.controller;

import com.aplicacao_spring.dto.AfiliacaoDTO;
import com.aplicacao_spring.dto.ArtigoDTO;
import com.aplicacao_spring.model.Afiliacao;
import com.aplicacao_spring.service.AfiliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/afiliacoes")
public class AfiliacaoController {

    @Autowired
    private AfiliacaoService afiliacaoService;

    // Endpoint para criar uma nova afiliação
    @PostMapping
    public ResponseEntity<Afiliacao> criarAfiliacao(@RequestBody Afiliacao afiliacao) {
        Afiliacao novaAfiliacao = afiliacaoService.salvarAfiliacao(afiliacao);
        return new ResponseEntity<>(novaAfiliacao, HttpStatus.CREATED);
    }
    // Endpoint para listar todas as afiliações
    @GetMapping
    public ResponseEntity<List<AfiliacaoDTO>> listaAfiliacoes() {
        List<AfiliacaoDTO> afiliacoes = afiliacaoService.listarTodas();
        return ResponseEntity.ok(afiliacoes);
    }

    // Endpoint para obter uma afiliação específica por ID
    @GetMapping("/{id}")
    public ResponseEntity<Afiliacao> buscarAfiliacaoPorId(@PathVariable Long id) {
        Afiliacao afiliacao = afiliacaoService.buscarPorId(id);
        return afiliacao != null ? ResponseEntity.ok(afiliacao) : ResponseEntity.notFound().build();
    }

    // Endpoint para atualizar uma afiliação
    @PutMapping("/{id}")
    public ResponseEntity<AfiliacaoDTO> atualizarAfiliacao(@PathVariable Long id, @RequestBody AfiliacaoDTO afiliacaoDTO) {
        AfiliacaoDTO afiliacaoAtualizada = afiliacaoService.atualizarAfiliacao(id, afiliacaoDTO);
        return ResponseEntity.ok(afiliacaoAtualizada);
    }

    // Endpoint para deletar uma afiliação
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAfiliacao(@PathVariable Long id) {
        afiliacaoService.deletarAfiliacao(id);
        return ResponseEntity.noContent().build();
    }

}
