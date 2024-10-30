package com.aplicacao_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicacao_spring.model.RevistaCientifica;

public interface RevistaCientificaRepository extends JpaRepository<RevistaCientifica, Long>{
    boolean existsByIssn(String issn);

}
