package main.java.com.sistema.modelo;
public class PedidoEntregue extends PedidoEstado {
    @Override
    public void proximoEstado(Pedido pedido) {
        // Não há próximo estado
    }

    @Override
    public void anteriorEstado(Pedido pedido) {
        pedido.setEstado(new PedidoEnviado());
    }

    @Override
    public String getEstado() {
        return "Entregue";
    }
}
