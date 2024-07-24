package main.java.com.sistema.testes;

import org.junit.Test;

import main.java.com.sistema.modelo.Pagamento;

import static org.junit.Assert.*;

public class PagamentoTest {

    @Test
    public void testPagamento() {
        Pagamento pagamento = new Pagamento("Cartão de Crédito", 100.0);

        assertEquals("Cartão de Crédito", pagamento.getMetodoPagamento());
        assertEquals(100.0, pagamento.getValor(), 0.01);
    }

    @Test
    public void testSetMetodoPagamento() {
        Pagamento pagamento = new Pagamento("Cartão de Crédito", 100.0);
        pagamento.setMetodoPagamento("Pix");

        assertEquals("Pix", pagamento.getMetodoPagamento());
    }
}
