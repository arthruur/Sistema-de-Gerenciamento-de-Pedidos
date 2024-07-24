package main.java.com.sistema.testes;

import org.junit.Test;

import main.java.com.sistema.modelo.ProdutoEletronico;
import main.java.com.sistema.modelo.ProdutoRoupa;

import static org.junit.Assert.*;

public class ProdutoTest {

    @Test
    public void testProdutoEletronico() {
        ProdutoEletronico produto = new ProdutoEletronico("Smartphone", 999.99, "Smartphone de última geração");

        assertEquals("Smartphone", produto.getNome());
        assertEquals(999.99, produto.getPreco(), 0.01);
        assertEquals("Smartphone de última geração", produto.getDescricao());
        assertEquals("Eletrônico", produto.getCategoria());
    }

    @Test
    public void testProdutoRoupa() {
        ProdutoRoupa produto = new ProdutoRoupa("Camisa", 49.99, "Camisa de algodão");

        assertEquals("Camisa", produto.getNome());
        assertEquals(49.99, produto.getPreco(), 0.01);
        assertEquals("Camisa de algodão", produto.getDescricao());
        assertEquals("Roupa", produto.getCategoria());
    }

    @Test
    public void testProdutoToString() {
        ProdutoEletronico produtoEletronico = new ProdutoEletronico("Smartphone", 999.99, "Smartphone de última geração");
        ProdutoRoupa produtoRoupa = new ProdutoRoupa("Camisa", 49.99, "Camisa de algodão");

        assertEquals("Smartphone", produtoEletronico.toString());
        assertEquals("Camisa", produtoRoupa.toString());
    }
}
