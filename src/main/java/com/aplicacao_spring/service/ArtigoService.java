package com.aplicacao_spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.aplicacao_spring.dto.ArtigoDTO;
import com.aplicacao_spring.model.Artigo;
import com.aplicacao_spring.model.Autor;
import com.aplicacao_spring.model.RevistaCientifica;
import com.aplicacao_spring.repository.ArtigoRepository;
import com.aplicacao_spring.repository.AutorRepository;
import com.aplicacao_spring.repository.RevistaCientificaRepository;

@Service
public class ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private RevistaCientificaRepository revistaRepository;

    public Artigo salvarArtigo(ArtigoDTO artigoDTO) {
        Artigo artigo = new Artigo();
        artigo.setTitulo(artigoDTO.getTitulo());
        artigo.setAnoPublicacao(artigoDTO.getAnoPublicacao());

        // Carregar e associar autores
        List<Autor> autores = autorRepository.findAllById(artigoDTO.getAutoresIds());
        if (autores.isEmpty()) {
            throw new RuntimeException("O artigo deve ter pelo menos um autor");
        }
        artigo.setAutores(autores);

        // Carregar e associar revista
        if (artigoDTO.getRevistaId() != null) {
            RevistaCientifica revista = revistaRepository.findById(artigoDTO.getRevistaId())
                    .orElseThrow(() -> new RuntimeException("Revista científica não encontrada"));
            artigo.setRevista(revista);
        } else {
            throw new RuntimeException("A revista científica é obrigatória");
        }

        return artigoRepository.save(artigo);
    }

    public Artigo updateArtigo(ArtigoDTO artigoDTO) {
        Artigo artigo = artigoRepository.findById(artigoDTO.getId())
                .orElseThrow(() -> new RuntimeException("Artigo não encontrado com o ID: " + artigoDTO.getId()));

        artigo.setTitulo(artigoDTO.getTitulo());
        artigo.setAnoPublicacao(artigoDTO.getAnoPublicacao());

        List<Autor> autores = autorRepository.findAllById(artigoDTO.getAutoresIds());
        if (autores.isEmpty()) {
            throw new RuntimeException("O artigo deve ter pelo menos um autor");
        }
        artigo.setAutores(autores);

        if (artigoDTO.getRevistaId() != null) {
            RevistaCientifica revista = revistaRepository.findById(artigoDTO.getRevistaId())
                    .orElseThrow(() -> new RuntimeException("Revista científica não encontrada"));
            artigo.setRevista(revista);
        } else {
            throw new RuntimeException("A revista científica é obrigatória");
        }

        return artigoRepository.save(artigo);
    }

    public void deleteById(Long id) {
        if (!artigoRepository.existsById(id)) {
            throw new RuntimeException("Artigo não encontrado com o ID: " + id);
        }
        artigoRepository.deleteById(id);
    }

    public List<Artigo> findAll() {
        return artigoRepository.findAll();
    }

    public Optional<Artigo> findById(Long id) {
        return artigoRepository.findById(id);
    }
}
