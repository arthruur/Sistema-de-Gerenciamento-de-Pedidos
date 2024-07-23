package main.java.com.sistema.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.java.com.sistema.exception.ProdutoNaoCadastrou;
import main.java.com.sistema.exception.QuantidadeNaoAlteradaException;

public class Admin implements Serializable{
    Estoque estoque;
    String senha; 
    LinkedList<Pedido> pedidos; 
    

    public Admin(Estoque estoque){
        this.estoque = estoque; 
        this.senha = "1234"; 
        this.pedidos = new LinkedList<>(); 

    }

    public Produto cadastrarProduto(String nome, double preco, int qtd, String desc, String categoria)throws ProdutoNaoCadastrou{
        return estoque.cadastrarProduto(nome, preco, desc, qtd, categoria);  
    }

    public boolean excluirProduto(Produto produto){
        return estoque.removerProduto(produto); 
    }

    public boolean adicionarProduto(Produto produto, int qtd)throws QuantidadeNaoAlteradaException{
        return estoque.adicionarQuantidade(produto, qtd); 
    }
    public boolean diminuirProduto(Produto produto, int qtd)throws QuantidadeNaoAlteradaException{
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
    public void adicionarPedido(Pedido pedido){
        pedidos.add(pedido); 
    }
    public LinkedList<Pedido> getPedidos(){
        return pedidos; 
    }

}
