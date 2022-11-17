package br.com.alura.loja.testes;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class CadastroDeProduto {
    public static void main(String[] args) {

        cadastraProduto();

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
