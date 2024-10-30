package com.aplicacao_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicacao_spring.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
