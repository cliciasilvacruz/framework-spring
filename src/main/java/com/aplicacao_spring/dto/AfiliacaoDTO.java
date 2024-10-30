package com.aplicacao_spring.dto;

import java.util.List;

public class AfiliacaoDTO {
    private Long id;
    private String nome;
    private String sigla;
    private String descricao;
    private List<Long> autorIds; // Lista de IDs de autores associados a essa afiliação

    // Construtor vazio (necessário para serialização)
    public AfiliacaoDTO(Long id, String nome, String sigla, List<Long> autoresIds) {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Long> getAutorIds() {
        return autorIds;
    }

    public void setAutorIds(List<Long> autorIds) {
        this.autorIds = autorIds;
    }

    public AfiliacaoDTO(Long id, String nome, String sigla, String descricao, List<Long> autorIds) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.descricao = descricao;
        this.autorIds = autorIds;
    }
}
