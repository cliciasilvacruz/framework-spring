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

import com.aplicacao_spring.model.RevistaCientifica;
import com.aplicacao_spring.service.RevistaCientificaService;

@RestController
@RequestMapping("/api/revistas")
public class RevistaCientificaController {

     @Autowired
    private RevistaCientificaService revistaCientificaService;

    public RevistaCientificaController(RevistaCientificaService revistaCientificaService) {
        this.revistaCientificaService = revistaCientificaService;
    }

    @GetMapping
    public List<RevistaCientifica> getAllRevistas() {
        return revistaCientificaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevistaCientifica> getRevistaById(@PathVariable Long id) {
        return revistaCientificaService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RevistaCientifica> createRevista(@RequestBody RevistaCientifica revista) {
        return ResponseEntity.ok(revistaCientificaService.save(revista));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RevistaCientifica> updateRevista(@PathVariable Long id, @RequestBody RevistaCientifica revista) {
        if (!revistaCientificaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        revista.setId(id);
        return ResponseEntity.ok(revistaCientificaService.save(revista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRevista(@PathVariable Long id) {
        if (!revistaCientificaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        revistaCientificaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
