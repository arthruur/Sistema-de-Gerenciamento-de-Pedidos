package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminTest {

    private Admin admin;
    private Estoque estoque;
    private Produto produto;
    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        estoque = new Estoque();
        admin = new Admin(estoque);
        produto = new Produto("Produto A", 10.0, 100, "Descrição do Produto A");
        pedido = new Pedido();
    }

    @Test
    public void testGerenciarEstoque() {
        admin.gerenciarEstoqueDeProdutos();
        // Verificar se o método realiza ações esperadas
    }

    @Test
    public void testProcessarEAprovarPedido() {
        pedido.adicionarItem(produto, 2);
        admin.processarEAprovarPedido(pedido);
        assertEquals("Processando", pedido.getEstado().getEstado());
    }

    @Test
    public void testAcompanharStatusDoPedido() {
        pedido.adicionarItem(produto, 2);
        assertEquals("Novo", admin.acompanharStatusDoPedido(pedido));
    }
}
