package com.aplicacao_spring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacao_spring.dto.AutorDTO;
import com.aplicacao_spring.model.Autor;
import com.aplicacao_spring.repository.AutorRepository;

@Service
public class AutorService {

   @Autowired
    private AutorRepository autorRepository;

    public Autor salvarAutor(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setNome(autorDTO.getNome());
        autor.setAfiliacao(autorDTO.getAfiliacao());
        return autorRepository.save(autor);
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

}
