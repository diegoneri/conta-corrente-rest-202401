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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "tb_movimentacao")
@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class Movimentacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	@Column(name = "vl_valor")
	private Float valor;
	@Enumerated(EnumType.STRING)
	@Column(name = "nm_tipo_movimentacao")
	private TipoMovimentacao tipo;
	@Column(name = "ds_descricao", length = 100)
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_data")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private Calendar data;
}

