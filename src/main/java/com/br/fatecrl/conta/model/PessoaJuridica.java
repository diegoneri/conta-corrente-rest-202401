package com.br.fatecrl.conta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private String cnpj;
    @Column(name="nm_ramo_atividade", length=20)
    private String ramoAtividade;

}
