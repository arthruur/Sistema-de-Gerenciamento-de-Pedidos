package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClasseEstoqueTest {

    @Test
    public void testCadastrarProduto() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto 1", 10.0);
        estoque.cadastrarProduto(produto);

        assertTrue(estoque.getProdutos().contains(produto));
    }

    @Test
    public void testModificarQtdDeProduto() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto 1", 10.0);
        estoque.cadastrarProduto(produto);
        estoque.modificarQtdDeProduto(produto, 20);

        assertEquals(20, produto.getQuantidade());
    }

    @Test
    public void testRemoverProduto() {
        Estoque estoque = new Estoque();
        Produto produto = new Produto("Produto 1", 10.0);
        estoque.cadastrarProduto(produto);
        estoque.removerProduto(produto);

        assertFalse(estoque.getProdutos().contains(produto));
    }
}
