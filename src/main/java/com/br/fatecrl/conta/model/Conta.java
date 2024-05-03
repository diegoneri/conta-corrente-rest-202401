package com.br.fatecrl.conta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nr_agencia", nullable = false)
	private Integer agencia;
	@Column(name = "nm_numero", nullable = false, length = 10)
	private String numero;
	@Column(name = "nm_titular", nullable = false, length = 100)
	private String titular;
	@Column(name = "vl_saldo", nullable = false)
	private Double saldo;

	public Conta() {

	}

	public Conta(Long id) {
		super.setId(id);
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
