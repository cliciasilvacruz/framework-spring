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

import com.aplicacao_spring.dto.AutorDTO;
import com.aplicacao_spring.model.Autor;
import com.aplicacao_spring.service.AutorService;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

     @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.findAll();
    }

    @PostMapping
    public Autor createAutor(@RequestBody AutorDTO autorDTO) {
        return autorService.salvarAutor(autorDTO);
    }

}
