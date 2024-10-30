package com.aplicacao_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao_spring.dto.RevistaCientificaDTO;
import com.aplicacao_spring.model.RevistaCientifica;
import com.aplicacao_spring.service.RevistaCientificaService;

@RestController
@RequestMapping("/api/revistas")
public class RevistaCientificaController {

   @Autowired
    private RevistaCientificaService revistaService;

    @GetMapping
    public List<RevistaCientifica> getAllRevistas() {
        return revistaService.findAll();
    }

    @PostMapping
    public RevistaCientifica createRevista(@RequestBody RevistaCientificaDTO revistaDTO) {
        return revistaService.salvarRevista(revistaDTO);
    }
}
