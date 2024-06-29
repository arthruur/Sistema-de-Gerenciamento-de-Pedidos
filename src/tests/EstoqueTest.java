package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstoqueTest {

    private Estoque estoque;
    private Produto produto;

    @BeforeEach
    public void setUp() {
        estoque = new Estoque();
        produto = new Produto("Produto A", 10.0, 100, "Descrição do Produto A");
    }

    @Test
    public void testCadastrarProduto() {
        estoque.cadastrarProduto(produto);
        assertEquals(1, estoque.getProdutos().size());
        assertEquals(produto, estoque.getProdutos().get(0));
    }

    @Test
    public void testRemoverProduto() {
        estoque.cadastrarProduto(produto);
        estoque.removerProduto(produto);
        assertTrue(estoque.getProdutos().isEmpty());
    }

    @Test
    public void testModificarQtdDeProduto() {
        estoque.cadastrarProduto(produto);
        estoque.modificarQtdDeProduto(produto, 50);
        assertEquals(50, produto.getQuantidadeEmEstoque());
    }
}
