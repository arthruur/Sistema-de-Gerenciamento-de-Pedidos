package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoEstadoTest {

    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
    }

    @Test
    public void testEstadoInicial() {
        assertTrue(pedido.getEstado() instanceof PedidoNovo);
        assertEquals("Novo", pedido.getEstado().getEstado());
    }

    @Test
    public void testTransicaoDeNovoParaProcessando() {
        pedido.proximoEstado();
        assertTrue(pedido.getEstado() instanceof PedidoProcessando);
        assertEquals("Processando", pedido.getEstado().getEstado());
    }

    @Test
    public void testTransicaoDeProcessandoParaEnviado() {
        pedido.proximoEstado(); // Novo -> Processando
        pedido.proximoEstado(); // Processando -> Enviado
        assertTrue(pedido.getEstado() instanceof PedidoEnviado);
        assertEquals("Enviado", pedido.getEstado().getEstado());
    }

    @Test
    public void testTransicaoDeEnviadoParaEntregue() {
        pedido.proximoEstado(); // Novo -> Processando
        pedido.proximoEstado(); // Processando -> Enviado
        pedido.proximoEstado(); // Enviado -> Entregue
        assertTrue(pedido.getEstado() instanceof PedidoEntregue);
        assertEquals("Entregue", pedido.getEstado().getEstado());
    }

    @Test
    public void testTransicaoReversaDeEntregueParaEnviado() {
        pedido.proximoEstado(); // Novo -> Processando
        pedido.proximoEstado(); // Processando -> Enviado
        pedido.proximoEstado(); // Enviado -> Entregue
        pedido.anteriorEstado(); // Entregue -> Enviado
        assertTrue(pedido.getEstado() instanceof PedidoEnviado);
        assertEquals("Enviado", pedido.getEstado().getEstado());
    }

    @Test
    public void testTransicaoReversaDeEnviadoParaProcessando() {
        pedido.proximoEstado(); // Novo -> Processando
        pedido.proximoEstado(); // Processando -> Enviado
        pedido.anteriorEstado(); // Enviado -> Processando
        assertTrue(pedido.getEstado() instanceof PedidoProcessando);
        assertEquals("Processando", pedido.getEstado().getEstado());
    }

    @Test
    public void testTransicaoReversaDeProcessandoParaNovo() {
        pedido.proximoEstado(); // Novo -> Processando
        pedido.anteriorEstado(); // Processando -> Novo
        assertTrue(pedido.getEstado() instanceof PedidoNovo);
        assertEquals("Novo", pedido.getEstado().getEstado());
    }

    @Test
    public void testSemTransicaoReversaDeNovo() {
        pedido.anteriorEstado(); // Tentativa de transição reversa do estado inicial
        assertTrue(pedido.getEstado() instanceof PedidoNovo);
        assertEquals("Novo", pedido.getEstado().getEstado());
    }

    @Test
    public void testSemTransicaoParaFrenteDeEntregue() {
        pedido.proximoEstado(); // Novo -> Processando
        pedido.proximoEstado(); // Processando -> Enviado
        pedido.proximoEstado(); // Enviado -> Entregue
        pedido.proximoEstado(); // Tentativa de transição para frente do estado final
        assertTrue(pedido.getEstado() instanceof PedidoEntregue);
        assertEquals("Entregue", pedido.getEstado().getEstado());
    }
}
