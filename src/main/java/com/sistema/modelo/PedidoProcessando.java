package main.java.com.sistema.modelo;
public class PedidoProcessando extends PedidoEstado {
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoEnviado());
    }

    @Override
    public void anteriorEstado(Pedido pedido) {
        pedido.setEstado(new PedidoNovo());
    }

    @Override
    public String getEstado() {
        return "Processando";
    }
}
