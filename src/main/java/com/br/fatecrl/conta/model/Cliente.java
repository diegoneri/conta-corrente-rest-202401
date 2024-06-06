package com.br.fatecrl.conta.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cliente extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	@Column(name = "nm_nome", length = 60)
	private String nome;
	@Column(name = "ds_endereco", length = 120)
	private String endereco;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "fk_conta_id", unique = true)
	private Conta conta;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Cliente() {
	}
}
