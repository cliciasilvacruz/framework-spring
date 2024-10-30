package com.aplicacao_spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private RevistaCientificaRepository revistaCientificaRepository;

    public ArtigoDTO criarArtigo(ArtigoDTO artigoDTO) {
        Artigo artigo = new Artigo();
        artigo.setTitulo(artigoDTO.getTitulo());
        artigo.setAnoPublicacao(artigoDTO.getAnoPublicacao());

        if (artigoDTO.getRevistaId() != null) {
            RevistaCientifica revista = revistaCientificaRepository.findById(artigoDTO.getRevistaId())
                    .orElseThrow(() -> new RuntimeException("Revista não encontrada"));
            artigo.setRevista(revista);
        }

        if (artigoDTO.getAutoresIds() != null) {
            List<Autor> autores = autorRepository.findAllById(artigoDTO.getAutoresIds());
            artigo.setAutores(autores);
        }

        artigo = artigoRepository.save(artigo);
        return new ArtigoDTO(artigo.getId(), artigo.getTitulo(), artigo.getAnoPublicacao(), artigoDTO.getAutoresIds(), artigoDTO.getRevistaId());
    }

    public ArtigoDTO buscarArtigoPorId(Long id) {
        Artigo artigo = artigoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artigo não encontrado com o ID " + id));
        List<Long> autoresIds = artigo.getAutores().stream().map(Autor::getId).toList();
        return new ArtigoDTO(artigo.getId(), artigo.getTitulo(), artigo.getAnoPublicacao(), autoresIds, artigo.getRevista() != null ? artigo.getRevista().getId() : null);
    }

    public ArtigoDTO atualizarArtigo(Long id, ArtigoDTO artigoDTO) {
        Artigo artigo = artigoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artigo não encontrado com o ID " + id));

        artigo.setTitulo(artigoDTO.getTitulo());
        artigo.setAnoPublicacao(artigoDTO.getAnoPublicacao());

        if (artigoDTO.getRevistaId() != null) {
            RevistaCientifica revista = revistaCientificaRepository.findById(artigoDTO.getRevistaId())
                    .orElseThrow(() -> new RuntimeException("Revista não encontrada"));
            artigo.setRevista(revista);
        }

        if (artigoDTO.getAutoresIds() != null) {
            List<Autor> autores = autorRepository.findAllById(artigoDTO.getAutoresIds());
            artigo.setAutores(autores);
        }

        artigo = artigoRepository.save(artigo);
        return new ArtigoDTO(artigo.getId(), artigo.getTitulo(), artigo.getAnoPublicacao(), artigoDTO.getAutoresIds(), artigoDTO.getRevistaId());
    }

    public void deletarArtigo(Long id) {
        if (!artigoRepository.existsById(id)) {
            throw new RuntimeException("Artigo não encontrado com o ID " + id);
        }
        artigoRepository.deleteById(id);
    }
    // Método para listar todos os artigos
    public List<ArtigoDTO> listarTodos() {
        List<Artigo> artigos = artigoRepository.findAll();
        return artigos.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Método auxiliar para converter uma entidade Artigo para ArtigoDTO
    private ArtigoDTO converterParaDTO(Artigo artigo) {
        List<Long> autoresIds = artigo.getAutores().stream()
                .map(Autor::getId)
                .collect(Collectors.toList());
        Long revistaId = artigo.getRevista() != null ? artigo.getRevista().getId() : null;

        return new ArtigoDTO(artigo.getId(), artigo.getTitulo(), artigo.getAnoPublicacao(), autoresIds, revistaId);
    }
}
