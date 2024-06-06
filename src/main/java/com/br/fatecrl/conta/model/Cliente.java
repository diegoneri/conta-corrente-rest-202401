package com.br.fatecrl.conta.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cliente")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public abstract class Cliente extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_nome", length = 60)
	private String nome;
	
	@Column(name = "ds_endereco", length = 120)
	private String endereco;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "fk_conta_id", unique = true)
	private Conta conta;

}
