package com.aplicacao_spring.model;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity(name = "artigo")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String titulo;
    
    @NonNull
    private Integer anoPublicacao;

    @ManyToMany
    @JoinTable(
        name = "artigo_autor",
        joinColumns = @JoinColumn(name = "artigo_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    @JsonManagedReference // Prevê recursão infinita para o lado "pai" do relacionamento
    @JsonIgnore
    private List<Autor> autores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "revista_id")
    private RevistaCientifica revista;


    public Artigo(){

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

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public RevistaCientifica getRevista() {
        return revista;
    }

    public void setRevista(RevistaCientifica revista) {
        this.revista = revista;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Artigo(Long id, String titulo, int anoPublicacao, RevistaCientifica revista, List<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.revista = revista;
        this.autores = autores;
    }

    public Iterable<Long> getAutoresIds() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAutoresIds'");
    }

    public Object getRevistaId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRevistaId'");
    }


}
