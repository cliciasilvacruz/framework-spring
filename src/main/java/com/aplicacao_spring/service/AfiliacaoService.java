package com.aplicacao_spring.service;

import com.aplicacao_spring.dto.AfiliacaoDTO;
import com.aplicacao_spring.model.Afiliacao;
import com.aplicacao_spring.model.Autor;
import com.aplicacao_spring.repository.AfiliacaoRepository;
import com.aplicacao_spring.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AfiliacaoService {

    @Autowired
    private AfiliacaoRepository afiliacaoRepository;
    @Autowired
    private AutorRepository autorRepository;

    public AfiliacaoDTO criarAfiliacao(AfiliacaoDTO afiliacaoDTO) {
        Afiliacao afiliacao = new Afiliacao();
        afiliacao.setNome(afiliacaoDTO.getNome());
        afiliacao.setSigla(afiliacaoDTO.getSigla());
        afiliacao = afiliacaoRepository.save(afiliacao);
        return converterParaDTO(afiliacao);
    }

    public Afiliacao salvarAfiliacao(Afiliacao afiliacao) {
        return afiliacaoRepository.save(afiliacao);
    }

    // Método para listar todas as afiliações
    public List<AfiliacaoDTO> listarTodas() {
        List<Afiliacao> afiliacoes = afiliacaoRepository.findAll();
        return afiliacoes.stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    // Método para buscar uma afiliação pelo ID
    public Afiliacao buscarPorId(Long id) {
        return afiliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Afiliacao não encontrada com o ID " + id));
    }

    // Método para atualizar uma afiliação existente
    public AfiliacaoDTO atualizarAfiliacao(Long id, AfiliacaoDTO afiliacaoDTO) {
        Afiliacao afiliacao = afiliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Afiliacao não encontrada com o ID " + id));
        afiliacao.setNome(afiliacaoDTO.getNome());
        afiliacao.setSigla(afiliacaoDTO.getSigla());
        afiliacao = afiliacaoRepository.save(afiliacao);
        return converterParaDTO(afiliacao);
    }

    // Método para deletar uma afiliação pelo ID
    public void deletarAfiliacao(Long id) {
        if (!afiliacaoRepository.existsById(id)) {
            throw new RuntimeException("Afiliacao não encontrada com o ID " + id);
        }
        afiliacaoRepository.deleteById(id);
    }

    // Método auxiliar para converter uma entidade Afiliacao em AfiliacaoDTO
    private AfiliacaoDTO converterParaDTO(Afiliacao afiliacao) {
        List<Long> autoresIds = afiliacao.getAutores().stream()
                .map(Autor::getId)
                .collect(Collectors.toList());
        return new AfiliacaoDTO(afiliacao.getId(), afiliacao.getNome(), afiliacao.getSigla(), autoresIds);
    }

    // Método auxiliar para converter um AfiliacaoDTO em uma entidade Afiliacao
    private Afiliacao converterParaEntidade(AfiliacaoDTO afiliacaoDTO) {
        Afiliacao afiliacao = new Afiliacao();
        afiliacao.setNome(afiliacaoDTO.getNome());
        afiliacao.setSigla(afiliacaoDTO.getSigla());

        if (afiliacaoDTO.getAutorIds() != null) {
            List<Autor> autores = autorRepository.findAllById(afiliacaoDTO.getAutorIds());
            afiliacao.setAutores(autores);
        }

        return afiliacao;
    }

}
