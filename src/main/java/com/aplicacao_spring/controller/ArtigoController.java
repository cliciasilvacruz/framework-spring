package com.aplicacao_spring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao_spring.dto.ArtigoDTO;
import com.aplicacao_spring.model.Artigo;
import com.aplicacao_spring.service.ArtigoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/artigos")
public class ArtigoController {

    @Autowired
    private ArtigoService artigoService;

    @GetMapping
    public List<Artigo> getAllArtigos() {
        return artigoService.findAll();
    }

    @PostMapping
    public Artigo createArtigo(@RequestBody ArtigoDTO artigoDTO) {
        return artigoService.salvarArtigo(artigoDTO);
    }

}
