package main.java.com.sistema.modelo;
public class Cliente {

    private String login;
    private String senha;
    private String nome;
    private String cpf; 
    private String endereço; 
    private String telefone; 
    private Pagamento pagamento; 
    private Carrinho carrinho;

    public Cliente(String login, String senha, String nome, String cpf, String endereço, String telefone){
        this.login = login; 
        this.senha = senha; 
        this.nome = nome; 
        this.cpf = cpf; 
        this.endereço = endereço; 
        this.telefone = telefone; 
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

    // Métodos para gerenciar carrinho e pagamentos
}
