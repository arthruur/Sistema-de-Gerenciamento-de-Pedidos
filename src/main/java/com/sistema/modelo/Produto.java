package main.java.com.sistema.modelo;

import java.io.Serializable;
import java.util.Objects;

public abstract class Produto implements Serializable {
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
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return nome.equals(produto.nome);
    }



    public abstract String getCategoria();

    // Construtor, getters e setters
}
