package com.br.fatecrl.conta.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_conta")
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class Conta extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nr_agencia", nullable = false)
	private Integer agencia;
	@Column(name = "nm_numero", nullable = false, length = 10)
	private String numero;
	@ToString.Exclude
	@Column(name = "vl_saldo", nullable = false)
	private Double saldo;

	@OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	@ToString.Exclude
	private List<Movimentacao> movimentacoes;


}
