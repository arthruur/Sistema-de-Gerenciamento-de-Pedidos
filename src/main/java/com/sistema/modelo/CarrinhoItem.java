package main.java.com.sistema.modelo;
public class CarrinhoItem {
    private Produto produto;
    private int quantidade;

    public CarrinhoItem(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getPrecoTotal() {
        return produto.getPreco() * quantidade;
    }

    public Produto geProduto(){
        return produto;
    }
    // Construtor, getters e setters
}
