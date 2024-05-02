package com.br.fatecrl.conta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.fatecrl.conta.model.Conta;

@Repository
public interface ContaRepository extends
                       JpaRepository<Conta, Long> {
}
