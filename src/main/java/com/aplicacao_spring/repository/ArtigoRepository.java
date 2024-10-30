package com.aplicacao_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicacao_spring.model.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Long>{

}
