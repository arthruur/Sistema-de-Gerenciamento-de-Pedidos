package main.java.com.sistema.modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import main.java.com.sistema.exception.UsuarioNaoCadastrouException;

public class GerenciaClientes implements Serializable{
    private Map<String, Cliente> clientes;

    public GerenciaClientes(){
        this.clientes = new HashMap<>();
    }

    public Cliente cadastrarCliente(String login, String senha, String nome, String cpf, String endereço, String telefone)throws UsuarioNaoCadastrouException{
        if (clientes.containsKey(login)){
            throw new UsuarioNaoCadastrouException("Não foi possível cadastrar o usuário, login já existente.");
        }
        else if (senha == null || senha.isEmpty() || nome.isEmpty() || cpf.isEmpty() || endereço.isEmpty() || telefone.isEmpty()){
            throw new UsuarioNaoCadastrouException("Não foi possível cadastrar o usuário, preencha todos os campos"); 
        }

        Cliente cliente = new Cliente(login, senha, nome, cpf, endereço, telefone);
        clientes.put(login, cliente);

        return cliente;
    }

    public Cliente getCliente(String login){
        return clientes.get(login);
    }
}
