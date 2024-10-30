package com.aplicacao_spring.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aplicacao_spring.model.Artigo;
import com.aplicacao_spring.repository.ArtigoRepository;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    public ArtigoService(ArtigoRepository artigoRepository) {
        this.artigoRepository = artigoRepository;
    }

    public Optional<Artigo> findById(Long id) {
        return artigoRepository.findById(id);
    }

    public Artigo save(Artigo artigo) {
        return artigoRepository.save(artigo);
    }

    public void deleteById(Long id) {
        artigoRepository.deleteById(id);
    }

    public List<Artigo> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
