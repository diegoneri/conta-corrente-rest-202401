package com.br.fatecrl.conta.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_pessoa_fisica")
public class PessoaFisica extends Cliente {
    private static final long serialVersionUID = 1L;

    @CPF
    @Column(name="cd_cpf", length = 11)
    private String cpf;
    
	@NotBlank
	@Size(min = 4, max = 30)
    @Column(name="nm_profissao", length = 30)
    private String profissao; 

    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public PessoaFisica() { }

    // getters e setters
}

