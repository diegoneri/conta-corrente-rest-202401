package com.br.fatecrl.conta.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_conta")
public class Conta extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nr_agencia", nullable = false)
	private Integer agencia;
	@Column(name = "nm_numero", nullable = false, length = 10)
	private String numero;
	@Column(name = "vl_saldo", nullable = false)
	private Double saldo;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "conta_id")
	private List<Movimentacao> movimentacoes;

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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	//@JsonIgnore /*Indica que o atributo ou método anotado deve ser ignorado na serialização e desserialização*/
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	@JsonProperty /*Usada para mapear nomes de atributos em chaves JSON durante a serialização e desserialização*/
	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

}
