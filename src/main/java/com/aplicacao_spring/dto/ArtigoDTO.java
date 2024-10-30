package com.aplicacao_spring.dto;

import java.util.List;

public class ArtigoDTO {
    
    private Long id;
    private String titulo;
    private Integer anoPublicacao;
    private List<Long> autoresIds;  // IDs dos autores
    private Long revistaId;
    
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
