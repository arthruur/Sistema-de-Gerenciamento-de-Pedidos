package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClasseCarrinhoTest {

    @Test
    public void testAdicionarProduto() {
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto("Produto 1", 10.0);
        carrinho.adicionarProduto(produto);

        assertTrue(carrinho.getProdutos().contains(produto));
    }

    @Test
    public void testRemoverProduto() {
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto("Produto 1", 10.0);
        carrinho.adicionarProduto(produto);
        carrinho.removerProduto(produto);

        assertFalse(carrinho.getProdutos().contains(produto));
    }

    @Test
    public void testValorTotal() {
        Carrinho carrinho = new Carrinho();
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);
        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);

        assertEquals(30.0, carrinho.getValorTotal());
    }
}
