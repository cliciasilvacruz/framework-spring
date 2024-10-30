package com.aplicacao_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacao_spring.model.Autor;
import com.aplicacao_spring.repository.AutorRepository;

@Service
public class AutorService {

     @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    

}
