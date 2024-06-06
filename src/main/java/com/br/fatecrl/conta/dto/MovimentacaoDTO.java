package com.br.fatecrl.conta.dto;

import java.util.Calendar;

import com.br.fatecrl.conta.model.TipoMovimentacao;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
public class MovimentacaoDTO {
	@Min(1)
	@Max(100000)
	private Float valor;
	
	@NotNull(message = "Tipo requerido")
	private TipoMovimentacao tipo;
	
	@NotBlank(message = "Descrição requerida")
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@Past
	private Calendar data;	
}
