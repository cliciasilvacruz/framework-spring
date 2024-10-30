package com.aplicacao_spring.service;

import java.util.List;
import java.util.stream.Collectors;

import com.aplicacao_spring.model.Artigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aplicacao_spring.dto.RevistaCientificaDTO;
import com.aplicacao_spring.model.RevistaCientifica;
import com.aplicacao_spring.repository.RevistaCientificaRepository;

@Service
public class RevistaCientificaService {

    @Autowired
    private RevistaCientificaRepository revistaCientificaRepository;

    public RevistaCientificaDTO criarRevista(RevistaCientificaDTO revistaDTO) {
        RevistaCientifica revista = new RevistaCientifica();
        revista.setNome(revistaDTO.getNome());
        revista.setIssn(revistaDTO.getIssn());
        revista = revistaCientificaRepository.save(revista);
        return new RevistaCientificaDTO(revista.getId(), revista.getNome(), revista.getIssn(), null);
    }

    public RevistaCientificaDTO buscarRevistaPorId(Long id) {
        RevistaCientifica revista = revistaCientificaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revista não encontrada com o ID " + id));
        List<Long> artigosIds = revista.getArtigos().stream().map(Artigo::getId).toList();
        return new RevistaCientificaDTO(revista.getId(), revista.getNome(), revista.getIssn(), artigosIds);
    }

    public RevistaCientificaDTO atualizarRevista(Long id, RevistaCientificaDTO revistaDTO) {
        RevistaCientifica revista = revistaCientificaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revista não encontrada com o ID " + id));
        revista.setNome(revistaDTO.getNome());
        revista.setIssn(revistaDTO.getIssn());
        revista = revistaCientificaRepository.save(revista);
        return new RevistaCientificaDTO(revista.getId(), revista.getNome(), revista.getIssn(), null);
    }

    public void deletarRevista(Long id) {
        if (!revistaCientificaRepository.existsById(id)) {
            throw new RuntimeException("Revista não encontrada com o ID " + id);
        }
        revistaCientificaRepository.deleteById(id);
    }

    // Método para listar todas as revistas científicas
    public List<RevistaCientificaDTO> listarTodas() {
        List<RevistaCientifica> revistas = revistaCientificaRepository.findAll();
        return revistas.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Método auxiliar para converter uma entidade RevistaCientifica para RevistaCientificaDTO
    private RevistaCientificaDTO converterParaDTO(RevistaCientifica revista) {
        List<Long> artigosIds = revista.getArtigos().stream()
                .map(Artigo::getId)
                .collect(Collectors.toList());
        return new RevistaCientificaDTO(revista.getId(), revista.getNome(), revista.getIssn(), artigosIds);
    }
}
