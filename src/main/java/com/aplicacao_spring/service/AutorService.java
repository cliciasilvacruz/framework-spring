package com.aplicacao_spring.service;

import java.util.List;
import java.util.stream.Collectors;

import com.aplicacao_spring.dto.AutorDTO;
import com.aplicacao_spring.model.Afiliacao;
import com.aplicacao_spring.model.Artigo;
import com.aplicacao_spring.model.Autor;
import com.aplicacao_spring.repository.AfiliacaoRepository;
import com.aplicacao_spring.repository.ArtigoRepository;
import com.aplicacao_spring.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AfiliacaoRepository afiliacaoRepository;

    @Autowired
    private ArtigoRepository artigoRepository;

    public AutorDTO criarAutor(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setNome(autorDTO.getNome());

        // Atribuir afiliação e artigos ao autor
        atribuirAfiliacaoEArtigos(autor, autorDTO);

        // Salvar autor
        autor = autorRepository.save(autor);

        // Converter de volta para DTO
        return converterParaDTO(autor);
    }

    public AutorDTO buscarAutorPorId(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com o ID " + id));
        return converterParaDTO(autor);
    }

    public AutorDTO atualizarAutor(Long id, AutorDTO autorDTO) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado com o ID " + id));

        autor.setNome(autorDTO.getNome());

        // Atribuir afiliação e artigos ao autor
        atribuirAfiliacaoEArtigos(autor, autorDTO);

        autor = autorRepository.save(autor);
        return converterParaDTO(autor);
    }

    public void deletarAutor(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("Autor não encontrado com o ID " + id);
        }
        autorRepository.deleteById(id);
    }

    public List<AutorDTO> listarTodos() {
        List<Autor> autores = autorRepository.findAll();
        return autores.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private void atribuirAfiliacaoEArtigos(Autor autor, AutorDTO autorDTO) {
        // Atribuir afiliação se afiliacaoId for fornecido
        if (autorDTO.getAfiliacaoId() != null) {
            Afiliacao afiliacao = afiliacaoRepository.findById(autorDTO.getAfiliacaoId())
                    .orElseThrow(() -> new RuntimeException("Afiliacao não encontrada com o ID " + autorDTO.getAfiliacaoId()));
            autor.setAfiliacao(afiliacao);
        } else {
            autor.setAfiliacao(null);
        }

        // Atribuir artigos se artigosIds for fornecido
        if (autorDTO.getArtigosIds() != null && !autorDTO.getArtigosIds().isEmpty()) {
            List<Artigo> artigos = artigoRepository.findAllById(autorDTO.getArtigosIds());
            if (artigos.size() != autorDTO.getArtigosIds().size()) {
                throw new RuntimeException("Um ou mais artigos não foram encontrados");
            }
            autor.setArtigos(artigos);
        } else {
            autor.getArtigos().clear();
        }
    }

    private AutorDTO converterParaDTO(Autor autor) {
        List<Long> artigosIds = autor.getArtigos().stream()
                .map(Artigo::getId)
                .collect(Collectors.toList());
        Long afiliacaoId = autor.getAfiliacao() != null ? autor.getAfiliacao().getId() : null;

        return new AutorDTO(autor.getId(), autor.getNome(), afiliacaoId, artigosIds);
    }
}
