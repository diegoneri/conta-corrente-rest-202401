package com.br.fatecrl.conta.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.br.fatecrl.conta.dto.MovimentacaoDTO;
import com.br.fatecrl.conta.model.Movimentacao;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class MovimentacaoMapper {
	public Movimentacao toEntity(MovimentacaoDTO movimentacaoDTO) {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(movimentacaoDTO.getData());
		movimentacao.setDescricao(movimentacaoDTO.getDescricao());
		movimentacao.setTipo(movimentacaoDTO.getTipo());
		movimentacao.setValor(movimentacaoDTO.getValor());
		
		return movimentacao;
	}

	public MovimentacaoDTO toDTO(Movimentacao movimentacao) {
		MovimentacaoDTO movimentacaoDTO = new MovimentacaoDTO();
		movimentacaoDTO.setData(movimentacao.getData());
		movimentacaoDTO.setDescricao(movimentacao.getDescricao());
		movimentacaoDTO.setTipo(movimentacao.getTipo());
		movimentacaoDTO.setValor(movimentacao.getValor());
		
		return movimentacaoDTO;
	}	
	
	public List<Movimentacao> toEntity(List<MovimentacaoDTO> movimentacoesDTO) {
		return movimentacoesDTO.stream()
				.map(this::toEntity)
				.collect(Collectors.toList());
	}
	
	public List<MovimentacaoDTO> toDTO(List<Movimentacao> movimentacoes) {
		return movimentacoes.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}	
}
