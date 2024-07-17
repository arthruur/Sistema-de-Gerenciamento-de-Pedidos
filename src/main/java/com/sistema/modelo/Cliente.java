package main.java.com.sistema.modelo;
public class Cliente {

    private String nome;
    private String login;
    private String senha;
    private Carrinho carrinho;

    public Cliente(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getLogin(){
        return login;
    }

    public String getSenha(){
        return senha;
    }

    // Métodos para gerenciar carrinho e pagamentos
}
