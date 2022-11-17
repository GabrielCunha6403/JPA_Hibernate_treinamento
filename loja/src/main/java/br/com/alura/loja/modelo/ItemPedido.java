package br.com.alura.loja.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private BigDecimal precoUnitario;
    @Getter @Setter
    private int quantidade;
    @ManyToOne
    @Getter @Setter
    private Pedido pedido;
    @ManyToOne
    @Getter @Setter
    private Produto produto;


    public ItemPedido() {}

    public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.precoUnitario = produto.getPreco();
        this.produto = produto;
    }
}
