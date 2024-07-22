package main.java.com.sistema.modelo;
import java.util.List;

public class Pedido {
    private Carrinho carrinho;
    private PedidoEstado estado; //simplificar para a mesma implementação de "status" do leilao
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
