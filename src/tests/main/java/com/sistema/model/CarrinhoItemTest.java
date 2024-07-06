package tests.main.java.com.sistema.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.sistema.modelo.*;

public class CarrinhoItemTest {

    private CarrinhoItem item;
    private Produto produto;

    @BeforeEach
    public void setUp() {
        produto = new Produto("Produto A", 10.0, 100, "Descrição do Produto A");
        item = new CarrinhoItem(produto, 2);
    }

    @Test
    public void testGetPrecoTotal() {
        assertEquals(20.0, item.getPrecoTotal());
    }

    @Test
    public void testGetProduto() {
        assertEquals(produto, item.getProduto());
    }

    @Test
    public void testGetQuantidade() {
        assertEquals(2, item.getQuantidade());
    }
}
