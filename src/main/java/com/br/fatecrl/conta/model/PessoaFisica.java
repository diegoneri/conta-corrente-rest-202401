package com.br.fatecrl.conta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private String cpf;
    @Column(name="nm_profissao", length = 30)
    private String profissao; 

}

