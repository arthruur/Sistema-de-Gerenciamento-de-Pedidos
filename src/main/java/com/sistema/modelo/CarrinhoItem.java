package main.java.com.sistema.modelo;
public class CarrinhoItem {
    private Produto produto;
    private int quantidade;

    public double getPrecoTotal() {
        return produto.getPreco() * quantidade;
    }

    // Construtor, getters e setters
}
