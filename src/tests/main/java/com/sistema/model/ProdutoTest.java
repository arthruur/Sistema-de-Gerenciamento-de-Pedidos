package tests.main.java.com.sistema.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.com.sistema.modelo.*;

public class ProdutoTest {

    private Produto produto;

    @BeforeEach
    public void setUp() {
        produto = new Produto("Produto A", 10.0, 100, "Descrição do Produto A");
    }

    @Test
    public void testGetNome() {
        assertEquals("Produto A", produto.getNome());
    }

    @Test
    public void testGetPreco() {
        assertEquals(10.0, produto.getPreco());
    }

    @Test
    public void testGetQuantidadeEmEstoque() {
        assertEquals(100, produto.getQuantidadeEmEstoque());
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Descrição do Produto A", produto.getDescricao());
    }

    @Test
    public void testSetPreco() {
        produto.setPreco(15.0);
        assertEquals(15.0, produto.getPreco());
    }
}
