package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    private Cliente cliente;
    private Produto produto;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("Cliente A");
        produto = new Produto("Produto A", 10.0, 100, "Descrição do Produto A");
    }

    @Test
    public void testAdicionarAoCarrinho() {
        cliente.adicionarAoCarrinho(produto, 2);
        assertEquals(1, cliente.getCarrinho().getItens().size());
        assertEquals(produto, cliente.getCarrinho().getItens().get(0).getProduto());
        assertEquals(2, cliente.getCarrinho().getItens().get(0).getQuantidade());
    }

    @Test
    public void testRemoverDoCarrinho() {
        cliente.adicionarAoCarrinho(produto, 2);
        cliente.removerDoCarrinho(produto);
        assertTrue(cliente.getCarrinho().getItens().isEmpty());
    }

    @Test
    public void testEfetuarPedido() {
        cliente.adicionarAoCarrinho(produto, 2);
        Pedido pedido = cliente.efetuarPedido();
        assertEquals(1, pedido.getItens().size());
        assertEquals(20.0, pedido.getValorTotal());
    }
}
