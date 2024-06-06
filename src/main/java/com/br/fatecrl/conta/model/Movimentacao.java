package com.br.fatecrl.conta.model;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Table(name = "tb_movimentacao")
@Entity
@Data
public class Movimentacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	@Column(name = "vl_valor")
	@Min(1)
	@Max(100000)
	private Float valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "nm_tipo_movimentacao")
	private TipoMovimentacao tipo;
	
	@Size(min = 4, max = 100)
	@Column(name = "ds_descricao", length = 100)
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_data")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Calendar data;

}

