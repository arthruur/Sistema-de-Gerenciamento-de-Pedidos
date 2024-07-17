package main.java.com.sistema.modelo;

import java.util.HashMap;
import java.util.Map;

import main.java.com.sistema.exception.UsuarioNaoCadastrouException;

public class GerenciarClientes {
    private Map<String, Cliente> clientes;

    public GerenciarClientes(){
        this.clientes = new HashMap<>();
    }

    public Cliente cadastrarCliente(String nome, String login, String senha)throws UsuarioNaoCadastrouException{
        if (clientes.containsKey(login) || senha == null || senha.isEmpty() || nome.isEmpty()){
            throw new UsuarioNaoCadastrouException("Não foi possível cadastrar o usuário.");
        }

        Cliente cliente = new Cliente(nome, login, senha);
        clientes.put(login, cliente);

        return cliente;
    }

    public Cliente getCliente(String login){
        return clientes.get(login);
    }
    // Construtor, getters e setters
}
