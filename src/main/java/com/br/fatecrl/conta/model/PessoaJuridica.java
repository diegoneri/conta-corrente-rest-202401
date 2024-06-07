package com.br.fatecrl.conta.model;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pessoa_juridica")
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public class PessoaJuridica extends Cliente {
    private static final long serialVersionUID = 1L;

    @Column(name="cd_cnpj", length=14)
    @CNPJ
    private String cnpj;
    @Column(name="nm_ramo_atividade", length=20)
	@NotBlank(message = "Ramo de atividade deve ser informado")
	@Size(min = 4, max = 20, message = "Informar de 4 a 20 caracteres")
    private String ramoAtividade;

}
