package main.java.com.sistema.modelo;

import java.io.Serializable;

public abstract class PedidoEstado implements Serializable {
    public abstract void proximoEstado(Pedido pedido);
    public abstract void anteriorEstado(Pedido pedido);
    public abstract String getEstado();
}
