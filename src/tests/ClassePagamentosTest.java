package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClassePagamentosTest {

    @Test
    public void testConhecerDetalhesDoPedido() {
        Pagamento pagamento = new Pagamento();
        Pedido pedido = new Pedido();
        pedido.setDetalhes("Detalhes do pedido");
        pagamento.setPedido(pedido);

        assertEquals("Detalhes do pedido", pagamento.getPedido().getDetalhes());
    }
}
