package com.aplicacao_spring.dto;

import java.util.List;

public class AutorDTO {
    private Long id;
    private String nome;
    private Long afiliacaoId;
    private List<Long> artigosIds;

    public AutorDTO(){}

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

    public Long getAfiliacaoId() {
        return afiliacaoId;
    }

    public void setAfiliacaoId(Long afiliacaoId) {
        this.afiliacaoId = afiliacaoId;
    }

    public List<Long> getArtigosIds() {
        return artigosIds;
    }

    public void setArtigosIds(List<Long> artigosIds) {
        this.artigosIds = artigosIds;
    }

    public AutorDTO(Long id, String nome, Long afiliacaoId, List<Long> artigosIds) {
        this.id = id;
        this.nome = nome;
        this.afiliacaoId = afiliacaoId;
        this.artigosIds = artigosIds;
    }
}
