public class PedidoEnviado extends PedidoEstado {
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoEntregue());
    }

    @Override
    public void anteriorEstado(Pedido pedido) {
        pedido.setEstado(new PedidoProcessando());
    }

    @Override
    public String getEstado() {
        return "Enviado";
    }
}
