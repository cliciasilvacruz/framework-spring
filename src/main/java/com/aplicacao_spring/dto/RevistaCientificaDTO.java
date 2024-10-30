package com.aplicacao_spring.dto;

import java.util.List;

public class RevistaCientificaDTO {
    private Long id;
    private String nome;
    private String issn;
    private List<Long> artigosIds;

    public RevistaCientificaDTO() {}

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

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public List<Long> getArtigosIds() {
        return artigosIds;
    }

    public void setArtigosIds(List<Long> artigosIds) {
        this.artigosIds = artigosIds;
    }

    public RevistaCientificaDTO(Long id, String nome, String issn, List<Long> artigosIds) {
        this.id = id;
        this.nome = nome;
        this.issn = issn;
        this.artigosIds = artigosIds;
    }
}
