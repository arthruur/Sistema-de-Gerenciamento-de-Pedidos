public abstract class PedidoEstado {
    public abstract void proximoEstado(Pedido pedido);
    public abstract void anteriorEstado(Pedido pedido);
    public abstract String getEstado();
}
