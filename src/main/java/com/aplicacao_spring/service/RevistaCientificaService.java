package com.aplicacao_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacao_spring.dto.RevistaCientificaDTO;
import com.aplicacao_spring.model.RevistaCientifica;
import com.aplicacao_spring.repository.RevistaCientificaRepository;

@Service
public class RevistaCientificaService {

    @Autowired
    private RevistaCientificaRepository revistaRepository;

    public RevistaCientifica salvarRevista(RevistaCientificaDTO revistaDTO) {
        if (revistaRepository.existsByIssn(revistaDTO.getIssn())) {
            throw new RuntimeException("ISSN já existe: " + revistaDTO.getIssn());
        }
        RevistaCientifica revista = new RevistaCientifica();
        revista.setNome(revistaDTO.getNome());
        revista.setIssn(revistaDTO.getIssn());
        return revistaRepository.save(revista);
    }

    public List<RevistaCientifica> findAll() {
        return revistaRepository.findAll();
    }

}
