package br.com.alura.spring.data.orm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "funcionarios")
@NoArgsConstructor
@ToString
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String nome;
    @Getter @Setter
    private String cpf;
    @Getter @Setter
    private Float salario;
    @Getter @Setter
    private Date dataContratacao;
    /*@ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "funcionarios_unidades", joinColumns = {
            @JoinColumn(name = "fk_funcionario")},
    inverseJoinColumns = { @JoinColumn(name = "fk_unidade")})
    private List<UnidadeTrabalho> unidadeTrabalho;*/

    public Funcionario(String nome, String cpf, Float salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataContratacao = new Date();
    }
}
