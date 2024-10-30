package com.aplicacao_spring.dto;

import com.aplicacao_spring.model.Artigo;

import java.util.List;

public class ArtigoDTO {
    
    private Long id;
    private String titulo;
    private Integer anoPublicacao;
    private List<Long> autoresIds;  // IDs dos autores
    private Long revistaId;

    public ArtigoDTO(){}

    public ArtigoDTO(Long id, String titulo, Integer anoPublicacao, List<Long> autoresIds, Long revistaId) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autoresIds = autoresIds;
        this.revistaId = revistaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public List<Long> getAutoresIds() {
        return autoresIds;
    }

    public void setAutoresIds(List<Long> autoresIds) {
        this.autoresIds = autoresIds;
    }

    public Long getRevistaId() {
        return revistaId;
    }

    public void setRevistaId(Long revistaId) {
        this.revistaId = revistaId;
    }
}
