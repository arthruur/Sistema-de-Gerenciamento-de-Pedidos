package main.java.com.sistema.modelo;

public abstract class Produto {
    private String nome;
    private double preco;
    private String descricao;

    public Produto(String nome, double preco, String descricao){
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco() {
        return preco; 
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString(){
        return nome; 
    }

    public abstract String getCategoria();

    // Construtor, getters e setters
}
