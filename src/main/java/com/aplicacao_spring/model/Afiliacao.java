package com.aplicacao_spring.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "afilicao")
public class Afiliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 100)
    private String nome;

    @NonNull
    private String sigla;
    @NonNull
    @Column(unique = true)
    private String referencia;

    @OneToMany(mappedBy = "afiliacao")
    private List<Autor> autores = new ArrayList<>();

    public Afiliacao(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NonNull
    public String getSigla() {
        return sigla;
    }

    public void setSigla(@NonNull String sigla) {
        this.sigla = sigla;
    }

    @NonNull
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(@NonNull String referencia) {
        this.referencia = referencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Afiliacao(String nome, @NonNull String sigla, @NonNull String referencia) {
        this.nome = nome;
        this.sigla = sigla;
        this.referencia = referencia;
    }
}
