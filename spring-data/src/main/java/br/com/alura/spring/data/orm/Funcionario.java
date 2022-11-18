package br.com.alura.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
    private Integer id;
    private String nome;
    private String cpf;
    private Float salario;
    private Date dataContratacao;
}
