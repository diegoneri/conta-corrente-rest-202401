package com.br.fatecrl.conta.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pessoa_fisica")
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class PessoaFisica extends Cliente {
    private static final long serialVersionUID = 1L;

    @Column(name="cd_cpf", length = 11)
    @CPF
    private String cpf;
    @Column(name="nm_profissao", length = 30)
	@NotBlank(message = "Profissão deve ser informada")
	@Size(min = 4, max = 30, message = "Informar de 4 a 30 caracteres")
    private String profissao; 

}

