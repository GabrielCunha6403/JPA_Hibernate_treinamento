package br.com.alura.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unidades_trabalho")
public class UnidadeTrabalho {
    private Integer id;
    private String descricao;
    private String endereco;
}
