package com.br.fatecrl.conta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.fatecrl.conta.model.Movimentacao;

import jakarta.transaction.Transactional;

public interface MovimentacaoRepository extends
		JpaRepository<Movimentacao, Long> {
	@Query(value = "SELECT * FROM tb_movimentacao m WHERE conta_id = :pConta", nativeQuery = true)
	List<Movimentacao> findByConta(@Param("pConta")Integer conta);
	
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tb_movimentacao "
    		+ "	(vl_valor,conta_id,dt_data,ds_descricao,nm_tipo_movimentacao) "
    		+ "VALUES " +
            "( " +
                ":#{#m.valor}, " +
                ":#{#pConta}, " +
                ":#{#m.data}, " +
                ":#{#m.descricao}, " +
                ":#{#m.tipo.name} " +
            ")", nativeQuery = true)
    void saveWithConta(@Param("m") Movimentacao movimentacao
    		       , @Param("pConta")Integer conta);

}	
