package main.java.com.sistema.testes;

import org.junit.Before;
import org.junit.Test;

import main.java.com.sistema.modelo.Carrinho;
import main.java.com.sistema.modelo.Produto;
import main.java.com.sistema.modelo.ProdutoEletronico;
import main.java.com.sistema.modelo.ProdutoRoupa;


import java.util.Map;

import static org.junit.Assert.*;

public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produtoEletronico;
    private Produto produtoRoupa;

    @Before
    public void setUp() {
        carrinho = new Carrinho();
        produtoEletronico = new ProdutoEletronico("Smartphone", 999.99, "Smartphone de última geração");
        produtoRoupa = new ProdutoRoupa("Camisa", 49.99, "Camisa de algodão");
    }

    @Test
    public void testAdicionarProdutoNovo() {
        carrinho.adicionarProduto(produtoEletronico, 2);
        Map<Produto, Integer> itens = carrinho.getItens();
        
        assertEquals(1, itens.size());
        assertTrue(itens.containsKey(produtoEletronico));
        assertEquals((Integer) 2, itens.get(produtoEletronico));
    }

    @Test
    public void testAdicionarProdutoExistente() {
        carrinho.adicionarProduto(produtoEletronico, 2);
        carrinho.adicionarProduto(produtoEletronico, 3);
        Map<Produto, Integer> itens = carrinho.getItens();

        assertEquals(1, itens.size());
        assertTrue(itens.containsKey(produtoEletronico));
        assertEquals((Integer) 5, itens.get(produtoEletronico));
    }

    @Test
    public void testRemoverProduto() {
        carrinho.adicionarProduto(produtoEletronico, 2);
        carrinho.removerProduto(produtoEletronico);
        Map<Produto, Integer> itens = carrinho.getItens();

        assertEquals(0, itens.size());
    }

    @Test
    public void testGetValorTotal() {
        carrinho.adicionarProduto(produtoEletronico, 2);
        carrinho.adicionarProduto(produtoRoupa, 3);
        double valorTotal = carrinho.getValorTotal();

        assertEquals(2149.95, valorTotal, 0.01);
    }

    @Test
    public void testEsvaziarCarrinho() {
        carrinho.adicionarProduto(produtoEletronico, 2);
        carrinho.adicionarProduto(produtoRoupa, 3);
        carrinho.esvaziar();
        Map<Produto, Integer> itens = carrinho.getItens();

        assertEquals(0, itens.size());
    }
}
