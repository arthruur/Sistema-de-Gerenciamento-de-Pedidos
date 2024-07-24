package main.java.com.sistema.modelo;
import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {
    private Carrinho carrinho;
    private PedidoEstado estado; 
    private Cliente cliente;
    private Pagamento pagamento; 

    public Pedido(Carrinho carrinho, Cliente cliente, Pagamento pagamento) {
        estado = new PedidoNovo(); // Estado inicial
        this.carrinho = carrinho; 
        this.pagamento = pagamento;
        this.cliente = cliente; 
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

    public Carrinho getCarrinho(){
        return carrinho;
    }

    public Pagamento getPagamento(){
        return pagamento; 
    }
}
