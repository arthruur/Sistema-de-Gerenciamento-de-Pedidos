package main.java.com.sistema.modelo;

import java.util.List;

public class Admin {
    Estoque estoque;
    String senha; 
    List<Pedido> pedidos; 
    

    public Admin(Estoque estoque){
        this.estoque = estoque; 
        this.senha = "1234"; 
    }

    public Produto cadastrarProduto(String nome, double preco, int qtd, String desc){
        return estoque.cadastrarProduto(nome, preco, desc, qtd);  
    }

    public boolean excluirProduto(Produto produto){
        return estoque.removerProduto(produto); 
    }

    public boolean adicionarProduto(Produto produto, int qtd){
        return estoque.adicionarQuantidade(produto, qtd); 
    }
    public boolean diminuirProduto(Produto produto, int qtd){
        return estoque.diminuirQuantidade(produto, qtd); 
    }

    public void processarEAprovarPedido(Pedido pedido) {
        pedido.proximoEstado();
    }

    public String acompanharStatusDoPedido(Pedido pedido) {
        return pedido.getEstado();
    }

    public String getSenha(){
        return senha; 
    }

    // Construtor, getters e setters
}
