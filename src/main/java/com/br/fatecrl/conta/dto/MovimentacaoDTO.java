package com.br.fatecrl.conta.dto;

import java.util.Calendar;

import com.br.fatecrl.conta.model.TipoMovimentacao;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovimentacaoDTO {
	@Min(1)
	@Max(9999)
	private Float valor;
	
	@NotNull(message = "Tipo requerido")
	private TipoMovimentacao tipo;

	@NotBlank(message = "Descrição deve ser informada")
	@Size(min = 4, max = 100, message = "Informar de 4 a 100 caracteres")
	private String descricao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@NotNull(message = "Data requerida")
	@Past
	private Calendar data;
}

