package main.java.com.sistema.modelo;
import java.util.List;

public class Pedido {
    private List<CarrinhoItem> itens;
    private PedidoEstado estado; // simplificar para a mesma implementação de "status" do leilao
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

    public Cliente getCliente(){
        return cliente;
    }

    public List<CarrinhoItem> getItens(){
        return itens;
    }
    // Construtor, getters e setters
}
