package com.aplicacao_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacao_spring.model.RevistaCientifica;
import com.aplicacao_spring.repository.RevistaCientificaRepository;

@Service
public class RevistaCientificaService {

    @Autowired
    private RevistaCientificaRepository revistaCientificaRepository;

    public RevistaCientificaService(RevistaCientificaRepository revistaCientificaRepository) {
        this.revistaCientificaRepository = revistaCientificaRepository;
    }

    public List<RevistaCientifica> findAll() {
        return revistaCientificaRepository.findAll();
    }

    public Optional<RevistaCientifica> findById(Long id) {
        return revistaCientificaRepository.findById(id);
    }

    public RevistaCientifica save(RevistaCientifica revista) {
        return revistaCientificaRepository.save(revista);
    }

    public void deleteById(Long id) {
        revistaCientificaRepository.deleteById(id);
    }


}
