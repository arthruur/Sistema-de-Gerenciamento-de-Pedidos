package main.java.com.sistema.testes;

import org.junit.Before;
import org.junit.Test;

import main.java.com.sistema.modelo.Pedido;
import main.java.com.sistema.modelo.Carrinho; 
import main.java.com.sistema.modelo.Cliente;
import main.java.com.sistema.modelo.Pagamento; 
import main.java.com.sistema.modelo.Produto;
import main.java.com.sistema.modelo.ProdutoEletronico; 
import main.java.com.sistema.modelo.PedidoEstado; 
import main.java.com.sistema.modelo.PedidoEnviado; 



import static org.junit.Assert.*;

public class PedidoTest {

    private Pedido pedido;
    private Carrinho carrinho;
    private Cliente cliente;
    private Pagamento pagamento;

    @Before
    public void setUp() {
        carrinho = new Carrinho();
        Produto produtoEletronico = new ProdutoEletronico("Smartphone", 999.99, "Smartphone de última geração");
        carrinho.adicionarProduto(produtoEletronico, 2);
        cliente = new Cliente("joao123", "senha123", "João", "123.456.789-00", "Rua A, 123", "987654321");
        pagamento = new Pagamento("Cartão de Crédito", 1999.98);
        pedido = new Pedido(carrinho, cliente, pagamento);
    }

    @Test
    public void testPedidoCriacao() {
        assertNotNull(pedido);
        assertEquals(carrinho, pedido.getCarrinho());
        assertEquals(cliente, pedido.getCliente());
        assertEquals(pagamento, pedido.getPagamento());
        assertEquals("Novo", pedido.getEstado());
    }

    @Test
    public void testProximoEstado() {
        pedido.proximoEstado();
        assertEquals("Processando", pedido.getEstado());
        pedido.proximoEstado();
        assertEquals("Enviado", pedido.getEstado());
        pedido.proximoEstado();
        assertEquals("Entregue", pedido.getEstado());
    }

    @Test
    public void testAnteriorEstado() {
        pedido.proximoEstado(); // Processando
        pedido.proximoEstado(); // Enviado
        pedido.anteriorEstado();
        assertEquals("Processando", pedido.getEstado());
        pedido.anteriorEstado();
        assertEquals("Novo", pedido.getEstado());
    }

    @Test
    public void testSetEstado() {
        PedidoEstado estadoEnviado = new PedidoEnviado();
        pedido.setEstado(estadoEnviado);
        assertEquals("Enviado", pedido.getEstado());
    }
}
