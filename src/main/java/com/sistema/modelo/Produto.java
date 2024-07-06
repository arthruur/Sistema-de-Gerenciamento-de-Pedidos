package main.java.com.sistema.modelo;
public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    private String descricao;

    public Produto(String nome, double preco, String descricao){
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }
    
    public void setQuantidadeEmEstoque(int novaQuantidade) {
        quantidadeEmEstoque = novaQuantidade; 
    }


    public double getPreco() {
        return preco; 
    }

    // Construtor, getters e setters
}
