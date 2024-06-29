package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoriaTest {

    private Categoria categoria;
    private Produto produto;

    @BeforeEach
    public void setUp() {
        categoria = new Categoria("Eletrônicos");
        produto = new Produto("Produto A", 10.0, 100, "Descrição do Produto A");
    }

    @Test
    public void testAdicionarProduto() {
        categoria.adicionarProduto(produto);
        assertEquals(1, categoria.getProdutos().size());
        assertEquals(produto, categoria.getProdutos().get(0));
    }

    @Test
    public void testRemoverProduto() {
        categoria.adicionarProduto(produto);
        categoria.removerProduto(produto);
        assertTrue(categoria.getProdutos().isEmpty());
    }

    @Test
    public void testGetNome() {
        assertEquals("Eletrônicos", categoria.getNome());
    }
}
