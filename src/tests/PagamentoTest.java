package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PagamentoTest {

    private Pagamento pagamento;
    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
        pagamento = new Pagamento("Cartão de Crédito", 20.0, pedido);
    }

    @Test
    public void testGetMetodo() {
        assertEquals("Cartão de Crédito", pagamento.getMetodo());
    }

    @Test
    public void testGetValor() {
        assertEquals(20.0, pagamento.getValor());
    }

    @Test
    public void testGetPedido() {
        assertEquals(pedido, pagamento.getPedido());
    }
}
