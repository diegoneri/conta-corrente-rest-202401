package com.br.fatecrl.conta.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_conta")

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Conta extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Agência requerida")
	@Column(name = "nr_agencia", nullable = false)
	private Integer agencia;
	
	@NotBlank(message = "Número da conta requerido")
	@Size(min = 4, max = 10)	
	@Column(name = "nm_numero", nullable = false, length = 10)
	private String numero;
	
	@NotBlank(message = "Saldo inicial requerido")
	@ToString.Exclude
	@Column(name = "vl_saldo", nullable = false)
	@Min(1)
	@Max(100000)
	private Double saldo;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private List<Movimentacao> movimentacoes;


	public Conta(Long id) {
		super.setId(id);
	}

}
