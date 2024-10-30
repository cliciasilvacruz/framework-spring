package com.aplicacao_spring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao_spring.model.Artigo;
import com.aplicacao_spring.service.ArtigoService;

@RestController
@RequestMapping("/api/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    public ArtigoController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }

    @GetMapping
    public List<Artigo> getAllArtigos() {
        return artigoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artigo> getArtigoById(@PathVariable Long id) {
        return artigoService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Artigo> createArtigo(@RequestBody Artigo artigo) {
        return ResponseEntity.ok(artigoService.save(artigo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artigo> updateArtigo(@PathVariable Long id, @RequestBody Artigo artigo) {
        if (!artigoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        artigo.setId(id);
        return ResponseEntity.ok(artigoService.save(artigo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtigo(@PathVariable Long id) {
        if (!artigoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        artigoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
