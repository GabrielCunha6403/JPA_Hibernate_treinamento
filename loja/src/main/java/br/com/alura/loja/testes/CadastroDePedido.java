package br.com.alura.loja.testes;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.*;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class CadastroDePedido {
    public static void main(String[] args) {
        cadastraProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto = produtoDao.buscarPorId(1l);

        em.getTransaction().begin();

        Pedido pedido = new Pedido(new Cliente("Rodrigo", "12346"));
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);

        em.getTransaction().commit();

    }

    public static void cadastraProduto(){
        Categoria celulares = new Categoria("Celular");

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(celulares);
        celulares.setNome("XPTO");

        em.getTransaction().commit();
        em.close();
    }

}
