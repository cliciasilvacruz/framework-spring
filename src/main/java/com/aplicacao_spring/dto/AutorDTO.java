package com.aplicacao_spring.dto;

import java.util.List;

public class AutorDTO {
    private Long id;
    private String nome;
    private String afiliacao;
    private List<Long> artigosIds;

    
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
    public String getAfiliacao() {
        return afiliacao;
    }
    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }
    public List<Long> getArtigosIds() {
        return artigosIds;
    }
    public void setArtigosIds(List<Long> artigosIds) {
        this.artigosIds = artigosIds;
    }

    

}
