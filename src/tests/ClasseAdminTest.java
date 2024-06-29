package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClasseAdminTest {

    @Test
    public void testGerenciarEstoqueDeProdutos() {
        Admin admin = new Admin();
        Estoque estoque = new Estoque();
        admin.setEstoque(estoque);

        assertEquals(estoque, admin.getEstoque());
    }

    @Test
    public void testProcessarEAprovarPedidos() {
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        admin.processarEAprovarPedido(pedido);

        assertEquals("Processado", pedido.getStatus());
    }

    @Test
    public void testAcompanharStatusDosPedidos() {
        Admin admin = new Admin();
        Pedido pedido = new Pedido();
        pedido.setStatus("Enviado");
        admin.acompanharStatusDoPedido(pedido);

        assertEquals("Enviado", admin.getStatusDoPedido(pedido));
    }
}
