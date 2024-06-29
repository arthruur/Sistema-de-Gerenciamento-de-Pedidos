package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClassePedidoTest {

    @Test
    public void testConhecerCarrinho() {
        Pedido pedido = new Pedido();
        Carrinho carrinho = new Carrinho();
        pedido.setCarrinho(carrinho);

        assertEquals(carrinho, pedido.getCarrinho());
    }
}
