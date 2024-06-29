package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClasseClienteTest {

    @Test
    public void testModificarCarrinho() {
        Cliente cliente = new Cliente();
        Carrinho carrinho = new Carrinho();
        Produto produto = new Produto("Produto 1", 10.0);
        carrinho.adicionarProduto(produto);
        cliente.setCarrinho(carrinho);

        assertTrue(cliente.getCarrinho().getProdutos().contains(produto));
    }

    @Test
    public void testEfetuarPagamento() {
        Cliente cliente = new Cliente();
        Pedido pedido = new Pedido();
        Pagamento pagamento = new Pagamento();
        cliente.efetuarPagamento(pedido, pagamento);

        assertEquals(pedido, pagamento.getPedido());
    }
}
