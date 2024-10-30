package com.aplicacao_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacao_spring.model.Artigo;
import com.aplicacao_spring.repository.ArtigoRepository;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    public List<Artigo> getAllArtigos() {
        return artigoRepository.findAll();
    }

    public Artigo saveArtigo(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

}
