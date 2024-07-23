package main.java.com.sistema.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{

    private String login;
    private String senha;
    private String nome;
    private String cpf; 
    private String endereço; 
    private String telefone; 
    private Carrinho carrinho;
    private ArrayList<Pedido> pedidos; 

    public Cliente(String login, String senha, String nome, String cpf, String endereço, String telefone){
        this.login = login; 
        this.senha = senha; 
        this.nome = nome; 
        this.cpf = cpf; 
        this.endereço = endereço; 
        this.telefone = telefone; 
        this.carrinho = new Carrinho();
        this.pedidos = new ArrayList<Pedido>(); 

    }

    public String getLogin(){
        return login;
    }

    public String getSenha(){
        return senha;
    }

    public String getNome(){
        return nome; 
    }

    public String getCpf(){
        return cpf; 
    }

    public String getEndereço(){
        return endereço; 
    }

    public String getTelefone(){
        return telefone; 
    }

    public Carrinho getCarrinho(){
        return carrinho; 
    }

    public ArrayList<Pedido> getPedidos(){
        return pedidos; 
    }
    public void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

}
