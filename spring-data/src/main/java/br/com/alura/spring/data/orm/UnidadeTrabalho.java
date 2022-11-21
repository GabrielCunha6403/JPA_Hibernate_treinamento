package br.com.alura.spring.data.orm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "unidadestrabalho")
@NoArgsConstructor
@ToString
public class UnidadeTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String descricao;
    @Getter @Setter
    private String endereco;
    /*@ManyToMany(mappedBy = "unidadeTrabalho")
    @Getter @Setter
    private List<Funcionario> funcionarios;*/

    public UnidadeTrabalho(String descricao, String endereco) {
        this.descricao = descricao;
        this.endereco = endereco;
    }
}
