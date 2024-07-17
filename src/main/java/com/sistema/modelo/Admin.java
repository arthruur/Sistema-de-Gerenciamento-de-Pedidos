package main.java.com.sistema.modelo;

import java.util.List;

public class Admin {
    Estoque estoque;
    List<Pedido> pedidos; 
    

    public Admin(Estoque estoque){
        this.estoque = estoque; 
    }

    public void cadastrarProduto(String nome, double preco, int qtd, String desc){
        estoque.cadastrarProduto(nome, preco, desc, qtd);  
    }

    public boolean excluirProduto(Produto produto){
        return estoque.removerProduto(produto); 
    }

    public boolean adicionarProduto(Produto produto, int qtd){
        return estoque.adicionarQuantidade(produto, qtd); 

    }
    public void gerenciarEstoqueDeProdutos() {
        // Implementação para gerenciar o estoque
    }

    public void processarEAprovarPedido(Pedido pedido) {
        pedido.proximoEstado();
    }

    public String acompanharStatusDoPedido(Pedido pedido) {
        return pedido.getEstado();
    }

    // Construtor, getters e setters
}
