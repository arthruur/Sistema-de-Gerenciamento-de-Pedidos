package main.java.com.sistema.modelo;
import java.util.List;

public class Pedido {
    private List<CarrinhoItem> itens;
    private PedidoEstado estado;
    private Cliente cliente;

    public Pedido() {
        estado = new PedidoNovo(); // Estado inicial
    }

    public void proximoEstado() {
        estado.proximoEstado(this);
    }

    public void anteriorEstado() {
        estado.anteriorEstado(this);
    }

    public String getEstado() {
        return estado.getEstado();
    }

    public void setEstado(PedidoEstado estado){
        this.estado = estado; 
        
    }


    // Construtor, getters e setters
}
