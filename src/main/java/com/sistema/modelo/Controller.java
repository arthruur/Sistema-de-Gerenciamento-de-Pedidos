package main.java.com.sistema.modelo;

import main.java.com.sistema.exception.LoginFalhouException;

public class Controller {
    private GerenciarClientes clientes;
    private Cliente clienteAtivo;

    public Controller(){
        this.clientes = new GerenciarClientes();
    }

    public Cliente fazerLogin(String login, String senha) throws LoginFalhouException{
        Cliente cliente = clientes.getCliente(login);
        if (cliente == null || !cliente.getSenha().equals(senha)) {
            throw new LoginFalhouException("Não foi possível efetuar o login");
        }
        clienteAtivo = cliente;
        return cliente;

    }

    public Cliente getClienteAtivo() {
        return clienteAtivo;
    }
}
