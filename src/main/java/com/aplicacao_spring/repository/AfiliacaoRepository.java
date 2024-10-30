package com.aplicacao_spring.repository;

import com.aplicacao_spring.model.Afiliacao;
import com.aplicacao_spring.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfiliacaoRepository extends JpaRepository<Afiliacao, Long> {
}
