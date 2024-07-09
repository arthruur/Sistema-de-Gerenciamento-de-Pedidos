package tests.main.java.com.sistema.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.com.sistema.modelo.*;

public class EstoqueTest {

    private Estoque estoque;
    private Produto produto;

    @BeforeEach
    public void setUp() {
        estoque = Estoque.getInstance();
        estoque.limparEstoque();
    }

    @Test
    public void testCadastrarProduto() {
        Produto produto = estoque.cadastrarProduto("Produto A", 10.0, "Descrição do Produto A", 10);
        assertEquals(1, estoque.getProdutos().size());
        assertEquals(10, estoque.getProdutos().get(produto));
    }

    @Test
    public void testModificarQtdDeProduto() {
        produto = estoque.cadastrarProduto("Produto A", 10.0, "Descrição do Produto A", 10);
        estoque.removerQuantidade(produto, 5);
        assertTrue(estoque.getProdutos().get(produto) == 5);

        estoque.adicionarQuantidade(produto, 5);
        assertTrue(estoque.getProdutos().get(produto) == 10);
    }
}
