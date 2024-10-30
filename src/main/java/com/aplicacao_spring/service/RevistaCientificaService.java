package com.aplicacao_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacao_spring.model.RevistaCientifica;
import com.aplicacao_spring.repository.RevistaCientificaRepository;

@Service
public class RevistaCientificaService {

     @Autowired
    private RevistaCientificaRepository revistaRepository;

    public List<RevistaCientifica> getAllRevistas() {
        return revistaRepository.findAll();
    }

    public RevistaCientifica saveRevista(RevistaCientifica revista) {
        return revistaRepository.save(revista);
    }


}
