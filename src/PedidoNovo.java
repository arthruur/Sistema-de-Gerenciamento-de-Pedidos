public class PedidoNovo extends PedidoEstado {
    @Override
    public void proximoEstado(Pedido pedido) {
        pedido.setEstado(new PedidoProcessando());
    }

    @Override
    public void anteriorEstado(Pedido pedido) {
        // Não há estado anterior
    }

    @Override
    public String getEstado() {
        return "Novo";
    }
}
