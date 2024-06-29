package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    private Pedido pedido;
    private Produto produto;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
        produto = new Produto("Produto A", 10.0, 100, "Descrição do Produto A");
    }

    @Test
    public void testAdicionarItem() {
        pedido.adicionarItem(produto, 2);
        assertEquals(1, pedido.getItens().size());
        assertEquals(produto, pedido.getItens().get(0).getProduto());
        assertEquals(2, pedido.getItens().get(0).getQuantidade());
    }

    @Test
    public void testRemoverItem() {
        pedido.adicionarItem(produto, 2);
        pedido.removerItem(produto);
        assertTrue(pedido.getItens().isEmpty());
    }

    @Test
    public void testGetValorTotal() {
        pedido.adicionarItem(produto, 2);
        assertEquals(20.0, pedido.getValorTotal());
    }
}
